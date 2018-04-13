package rotacsufbo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

//TODO: if it says RETURN do nothing!
//TODO: fix methods that have to return things!
//TODO: Numbering strategies

public class ClassFlattener {
    private ClassOrInterfaceDeclaration classDec;

    private List<MethodDeclaration> methods;
    private List<List<Statement>> statements = new ArrayList<>();
    private List<List<Statement>> declarations = new ArrayList<>();
    public final String SWITCH_SELECTOR = "switchOnThis";
    public final String WHILE_VARIABLE = "infiniteLoop";
    private List<List<String>> uuidList = new ArrayList<>();


    public ClassFlattener(ClassOrInterfaceDeclaration cls) {
        classDec = cls;
        methods = cls.getMethods();
    }

    private void createUUID(List<List<Statement>> statements, List<MethodDeclaration> methods) {
        for (MethodDeclaration m: methods) {
            List<String> randomIdList = new ArrayList<>();
            for (Statement s: statements.get(methods.indexOf(m))) {
                randomIdList.add(UUID.randomUUID().toString());
            }
            randomIdList.add(UUID.randomUUID().toString()); //this one goes nowhere
            uuidList.add(randomIdList);
        }

    }

    public void createStatements() {
        for (MethodDeclaration m: methods) {
            // Create statement/declaration lists
            List<Statement> statement = new ArrayList<>();
            List<Statement> declaration = new ArrayList<>();

            Optional<BlockStmt> body = m.getBody();
            //TODO: Add check if body isPresent() for INTERFACES and ABSTRACT CLASSES
            NodeList<Statement> stmts = body.get().getStatements();

            for (Statement s: stmts) {
                List<VariableDeclarator> varDeclarators = s.findAll(VariableDeclarator.class);
                if (varDeclarators.isEmpty()) {
                    statement.add(s);
                } else {
                    for (VariableDeclarator v: varDeclarators) {
                        String def = v.getType() + " " + v.getName() + " = " + DefaultsHelper.getDefault(v.getType().toString()) +";";
                        String use = v.toString() + ";";


                        declaration.add(JavaParser.parseStatement(def));
                        statement.add(JavaParser.parseStatement(use));
                    }
                }
            }
            statements.add(statement);
            declarations.add(declaration);
        }
    }

    public void createSwitch() {
        // strategy is good but doesn't seem TOO object oriented since i'm passing everything
        createUUID(statements, methods);
        for (MethodDeclaration m : methods) {
            SwitchStmt switchStatement = new SwitchStmt();
            switchStatement.setSelector(JavaParser.parseExpression(SWITCH_SELECTOR));
            NodeList<SwitchEntryStmt> entries = new NodeList<>();
            // This value can be changed based on the strategy of randomization
//            System.out.println(uuidList);
            List<String> idList = uuidList.get(methods.indexOf(m));
            int switchToValueIndex = 0;
            String startSwitch = idList.get(switchToValueIndex);
            String switchToValue = idList.get(switchToValueIndex);
            OpaquePredator op = new OpaquePredator();


            for (Statement stmt : statements.get(methods.indexOf(m))) {
                SwitchEntryStmt entry = new SwitchEntryStmt();
                NodeList<Statement> entryStatements = new NodeList<>();
                entry.setLabel(JavaParser.parseExpression("\"" + switchToValue + "\""));
                switchToValueIndex++;
                switchToValue = idList.get(switchToValueIndex);
                // put the if statement here, wrap up the statements!
                IfStmt ifStatement = new IfStmt();

                // trueFirst or falseFirst?
                boolean trueFirst = ThreadLocalRandom.current().nextBoolean();

                if (trueFirst) {
                    ifStatement.setCondition(JavaParser.parseExpression(op.makeTrueExpression("OPAQUES") +""));
                    Statement sRandom = statements.get(methods.indexOf(m)).get(ThreadLocalRandom.current().nextInt(0, statements.get(methods.indexOf(m)).size()));
                    Statement correctSwitch = JavaParser.parseStatement(SWITCH_SELECTOR + " = \"" + switchToValue + "\";");
                    Statement incorrectSwitch = JavaParser.parseStatement(SWITCH_SELECTOR + " = \"" + UUID.randomUUID().toString() + "\";");
                    BlockStmt wrapperA = new BlockStmt();
                    BlockStmt wrapperB = new BlockStmt();
                    wrapperA.addStatement(stmt);
                    wrapperA.addStatement(correctSwitch);
                    wrapperB.addStatement(sRandom);
                    wrapperB.addStatement(incorrectSwitch);
                    ifStatement.setThenStmt(wrapperA);
                    ifStatement.setElseStmt(wrapperB); //wontrun
                } else {
                    ifStatement.setCondition(JavaParser.parseExpression(op.makeFalseExpression("OPAQUES") +""));
                    Statement sRandom = statements.get(methods.indexOf(m)).get(ThreadLocalRandom.current().nextInt(0, statements.get(methods.indexOf(m)).size()));
                    Statement correctSwitch = JavaParser.parseStatement(SWITCH_SELECTOR + " = \"" + switchToValue + "\";");
                    Statement incorrectSwitch = JavaParser.parseStatement(SWITCH_SELECTOR + " = \"" + UUID.randomUUID().toString() + "\";");

                    BlockStmt wrapperA = new BlockStmt();
                    BlockStmt wrapperB = new BlockStmt();

                    wrapperA.addStatement(sRandom);
                    wrapperA.addStatement(incorrectSwitch);
                    wrapperB.addStatement(stmt);
                    wrapperB.addStatement(correctSwitch);
                    ifStatement.setThenStmt(wrapperA); //wontrun
                    ifStatement.setElseStmt(wrapperB);
                }

//                entryStatements.add(stmt);
                entryStatements.add(ifStatement);
                // Compiler will pick up dead code if there's something after a return;
                if (!stmt.isReturnStmt()) {


//                    entryStatements.add(JavaParser.parseStatement(SWITCH_SELECTOR + " = \"" + switchToValue + "\";"));
                    entryStatements.add(JavaParser.parseStatement("break;"));
                }
                entry.setStatements(entryStatements);
                entries.add(entry);
            }

            //TODO: Add random switch statements.
            for (int i = 0; i < 5; i++) {
                SwitchEntryStmt entry = new SwitchEntryStmt();
                NodeList<Statement> entryStatements = new NodeList<>();
                entry.setLabel(JavaParser.parseExpression("\"" + UUID.randomUUID().toString() + "\""));
                // Have some sort of dummy code here.
                // TODO: If statements need to go here as well!
                Statement sRandom = statements.get(methods.indexOf(m)).get(ThreadLocalRandom.current().nextInt(0, statements.get(methods.indexOf(m)).size()));
                entryStatements.add(sRandom);
                entryStatements.add(JavaParser.parseStatement(SWITCH_SELECTOR + " = \"" + UUID.randomUUID().toString() + "\";"));
                entryStatements.add(JavaParser.parseStatement("break;"));

                entry.setStatements(entryStatements);
                entries.add(entry);

            }

            // Set a default one to break out of the loop
            NodeList<Statement> defaultSwitch = new NodeList<>();
            defaultSwitch.add(JavaParser.parseStatement(WHILE_VARIABLE + " = false;"));
            Collections.shuffle(entries); // so it's not, add this BEFORE the default in case
            entries.add(new SwitchEntryStmt(null, defaultSwitch));
            switchStatement.setEntries(entries);

            WhileStmt whileStatement = new WhileStmt();
            whileStatement.setCondition(JavaParser.parseExpression(WHILE_VARIABLE));
            whileStatement.setBody(switchStatement);

            BlockStmt blockStatement = new BlockStmt();

            for (Statement d : declarations.get(methods.indexOf(m))) {
                blockStatement.addStatement(d);
            }
            blockStatement.addStatement(JavaParser.parseStatement("String " + SWITCH_SELECTOR + " = \"" + startSwitch + "\";"));
            blockStatement.addStatement(JavaParser.parseStatement("boolean " + WHILE_VARIABLE + " = true;"));
            // generate array for opaque thing
            String stm = "int[] OPAQUES = new int[]{" + Arrays.toString(op.getOpaques()).substring(1, Arrays.toString(op.getOpaques()).length()-1) + "};";
            blockStatement.addStatement(JavaParser.parseStatement(stm));
            blockStatement.addStatement(whileStatement);


            // Have to return something otherwise it will be upset!
            if (!m.getTypeAsString().equals("void")) {
                String returnNothing = "return " + DefaultsHelper.getDefault(m.getTypeAsString()) + ";";
                blockStatement.addStatement(JavaParser.parseStatement(returnNothing));
            }

            m.setBody(blockStatement);
//            System.out.println(cls);
        }    }



}
