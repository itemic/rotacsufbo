package rotacsufbo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Flattens classes
 */
public class Flattener {
    private ClassOrInterfaceDeclaration classDeclaration;

    private List<MethodDeclaration> methods;
    private List<List<Statement>> statements = new ArrayList<>();
    private List<List<Statement>> declarations = new ArrayList<>();

    public final String SWITCH_SELECTOR = "switchOnThis";
    public final String INFINITE_LOOP = "infiniteLoop";

    private List<List<String>> uuids = new ArrayList<>();

    public Flattener(ClassOrInterfaceDeclaration classDeclaration) {
        this.classDeclaration = classDeclaration;
        methods = classDeclaration.getMethods();
    }

    /**
     * Create statements and declarations for each method
     * If there's a declaration with initialization, split them
     */
    public void createStatements() {
        for (MethodDeclaration m: methods) {

            //Create statement and declaration lists for this method
            List<Statement> statement = new ArrayList<>();
            List<Statement> declaration = new ArrayList<>();
            List<String> uuid = new ArrayList<>();
            //Get method body
            Optional<BlockStmt> body = m.getBody();

            if (body.isPresent()) {
                NodeList<Statement> bodyStatements = body.get().getStatements();
                for (Statement s: bodyStatements) {
                    //First add a UUID
                    uuid.add(UuidEncoder.uuidEncode(UUID.randomUUID().toString()));
                    //Don't break down the values in the for loop. Just treat it as a single statement.
                    if (s.isForStmt() || s.isForeachStmt()) {
                        statement.add(s);
                    } else {
                        List<VariableDeclarator> variableDeclarators = s.findAll(VariableDeclarator.class);
                        if (variableDeclarators.isEmpty()) {
                            statement.add(s);
                        } else {
                            for (VariableDeclarator v : variableDeclarators) {
                                String def = v.getType() + " " + v.getName() + " = " + DefaultsHelper.getDefault(v.getTypeAsString()) + ";";
                                String use = v.toString() + ";";
                                declaration.add(JavaParser.parseStatement(def));
                                statement.add(JavaParser.parseStatement(use));

                            }
                        }

                    }
                }
            }

            //add a random UUID so that there's a statement to break at
            uuid.add(UuidEncoder.uuidEncode(UUID.randomUUID().toString()));

            statements.add(statement);
            declarations.add(declaration);
            uuids.add(uuid);
        }
    }

    /**
     * Converts a method into one that uses switch statements
     * Requires manual removal of extraneous branching after a return
     */
    public void createSwitch() {
        for (MethodDeclaration m: methods) {
            SwitchStmt switchStmt = new SwitchStmt();
            switchStmt.setSelector(JavaParser.parseExpression(SWITCH_SELECTOR));
            NodeList<SwitchEntryStmt> switchEntries = new NodeList<>();

            List<String> uuidForMethod = uuids.get(methods.indexOf(m));
            int switchToValueIndex = 0;

            String startSwitchUuid = uuidForMethod.get(switchToValueIndex);
            String switchToValue = uuidForMethod.get(switchToValueIndex);

            OpaquePredicates op = new OpaquePredicates();


            // Create a switch entry for each statement
            for (Statement stmt: statements.get(methods.indexOf(m))) {
                SwitchEntryStmt switchEntry = new SwitchEntryStmt();
                NodeList<Statement> entryStatements = new NodeList<>();
                switchEntry.setLabel(JavaParser.parseExpression("\"" + switchToValue + "\""));
                switchToValueIndex++;


                switchToValue = uuidForMethod.get(switchToValueIndex);

                // Wrap statements within the switch with If/Else
                IfStmt ifStmt = new IfStmt();

                //Random statements
                boolean randomChoice = ThreadLocalRandom.current().nextBoolean();
                Statement randomStatement = statements.get(methods.indexOf(m)).get(ThreadLocalRandom.current().nextInt(0, statements.get(methods.indexOf(m)).size()));
                Statement correctSwitch = JavaParser.parseStatement(SWITCH_SELECTOR + " = \"" + switchToValue + "\";");
                Statement incorrectSwitch = JavaParser.parseStatement(SWITCH_SELECTOR + " = \"" + UuidEncoder.uuidEncode(UUID.randomUUID().toString()) + "\";");
                BlockStmt correctWrapper = new BlockStmt();
                correctWrapper.addStatement(stmt);
                correctWrapper.addStatement(correctSwitch);
                BlockStmt incorrectWrapper = new BlockStmt();
                incorrectWrapper.addStatement(randomStatement);
                incorrectWrapper.addStatement(incorrectSwitch);

                if (randomChoice) {
                    ifStmt.setCondition(op.makeTrueExpression("OPAQUES"));
                    ifStmt.setThenStmt(correctWrapper);
                    ifStmt.setElseStmt(incorrectWrapper);
                } else {
                    ifStmt.setCondition(op.makeFalseExpression("OPAQUES"));
                    ifStmt.setThenStmt(incorrectWrapper);
                    ifStmt.setElseStmt(correctWrapper);
                }

                entryStatements.add(ifStmt);
                if (!stmt.isReturnStmt()) {
                    entryStatements.add(JavaParser.parseStatement("break;"));
                }
                switchEntry.setStatements(entryStatements);
                switchEntries.add(switchEntry);
            }

            // Add random switch statements to be distracting, but not too much to increase size
            int statementCount = statements.get(methods.indexOf(m)).size() / 2;
            for (int rng = 0; rng < statementCount; rng++) {
                SwitchEntryStmt entryStmt = new SwitchEntryStmt();
                NodeList<Statement> entryStatements = new NodeList<>();
                entryStmt.setLabel(JavaParser.parseExpression("\"" + UuidEncoder.uuidEncode(UUID.randomUUID().toString()) + "\""));

                Statement randomStatement = statements.get(methods.indexOf(m)).get(ThreadLocalRandom.current().nextInt(0, statements.get(methods.indexOf(m)).size()));
                entryStatements.add(randomStatement);

                // make sure random statements don't return;
                if (!randomStatement.isReturnStmt()) {
                    entryStatements.add(JavaParser.parseStatement(SWITCH_SELECTOR + " = \"" + UuidEncoder.uuidEncode(UUID.randomUUID().toString()) + "\";"));
                    entryStatements.add(JavaParser.parseStatement("break;"));
                }


                entryStmt.setStatements(entryStatements);
                switchEntries.add(entryStmt);
            }

            // Default loop-breaking
            NodeList<Statement> defaultSwitch = new NodeList<>();
            defaultSwitch.add(JavaParser.parseStatement(INFINITE_LOOP + " = false;"));
            Collections.shuffle(switchEntries);
            switchEntries.add(new SwitchEntryStmt(null, defaultSwitch));

            switchStmt.setEntries(switchEntries);

            // Wrap the switch in a block
            BlockStmt switchBlock = new BlockStmt();
            switchBlock.addStatement(switchStmt);

            // Wrap this all in a while loop
            WhileStmt whileStmt = new WhileStmt();
            whileStmt.setCondition(JavaParser.parseExpression(INFINITE_LOOP));
            whileStmt.setBody(switchBlock);

            // Create declarations
            BlockStmt blockStmt = new BlockStmt();
            for (Statement d: declarations.get(methods.indexOf(m))) {
                blockStmt.addStatement(d);
            }

            //Add necessary stuff
            blockStmt.addStatement(JavaParser.parseStatement("String " + SWITCH_SELECTOR + " = \"" + startSwitchUuid + "\";"));
            blockStmt.addStatement(JavaParser.parseStatement("boolean " + INFINITE_LOOP + " = true;"));
            // generate array for opaque thing
            String opaqueValues = "int[] OPAQUES = new int[]{" + Arrays.toString(op.getOpaques()).substring(1, Arrays.toString(op.getOpaques()).length()-1) + "};";
            blockStmt.addStatement(JavaParser.parseStatement(opaqueValues));
            blockStmt.addStatement(whileStmt);

            if (!m.getTypeAsString().equals("void")) {
                String returnNothing = "return " + DefaultsHelper.getDefault(m.getTypeAsString()) + ";";
                blockStmt.addStatement(JavaParser.parseStatement(returnNothing));
            }

            m.setBody(blockStmt);
        }
    }

}
