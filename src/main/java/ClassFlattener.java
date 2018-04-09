import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO: if it says RETURN do nothing!
//TODO: fix methods that have to return things!

public class ClassFlattener {
    private ClassOrInterfaceDeclaration classDec;

    private List<MethodDeclaration> methods;
    private List<List<String>> statements = new ArrayList<>();
    private List<List<String>> declarations = new ArrayList<>();
    public final String SWITCH_SELECTOR = "switchOnThis";
    public final String WHILE_VARIABLE = "infiniteLoop";

    public ClassFlattener(ClassOrInterfaceDeclaration cls) {
        classDec = cls;
        methods = cls.getMethods();
    }

    public void createStatements() {
        for (MethodDeclaration m: methods) {
            // Create statement/declaration lists
            List<String> statement = new ArrayList<>();
            List<String> declaration = new ArrayList<>();

            Optional<BlockStmt> body = m.getBody();
            NodeList<Statement> stmts = body.get().getStatements();

            for (Statement s: stmts) {
                List<VariableDeclarator> varDeclarators = s.findAll(VariableDeclarator.class);
                if (varDeclarators.isEmpty()) {
                    statement.add(s.toString());
                } else {
                    for (VariableDeclarator v: varDeclarators) {
                        String init = v.getType() + " " + v.getName() + " = " + DefaultsHelper.getDefault(v.getType().toString()) +";";
//                        String init = v.getType() + " " + v.getName() + " = 0;";

                        System.out.println(v.getType());

                        declaration.add(init);
                        statement.add(v.toString() + ";");
                    }
                }
            }
            statements.add(statement);
            declarations.add(declaration);
        }
    }

    public void createSwitch() {
        for (MethodDeclaration m: methods) {
            SwitchStmt switchStatement = new SwitchStmt();
            switchStatement.setSelector(JavaParser.parseExpression(SWITCH_SELECTOR));
            NodeList<SwitchEntryStmt> entries = new NodeList<>();
            // This value can be changed based on the strategy of randomization
            int switchToValue = 0;
            System.out.println(methods.indexOf(m));

            for (String stmt: statements.get(methods.indexOf(m))) {
                SwitchEntryStmt entry = new SwitchEntryStmt();
                NodeList<Statement> entryStatements = new NodeList<>();

                entry.setLabel(JavaParser.parseExpression(switchToValue + ""));
                switchToValue++;

                entryStatements.add(JavaParser.parseStatement(stmt));
                entryStatements.add(JavaParser.parseStatement(SWITCH_SELECTOR + "++;"));
                entryStatements.add(JavaParser.parseStatement("break;"));

                entry.setStatements(entryStatements);

                entries.add(entry);
            }

            // Set a default one to break out of the loop
            NodeList<Statement> defaultSwitch = new NodeList<>();
            defaultSwitch.add(JavaParser.parseStatement(WHILE_VARIABLE + " = false;"));
            entries.add(new SwitchEntryStmt(null, defaultSwitch));
            switchStatement.setEntries(entries);

            WhileStmt whileStatement = new WhileStmt();
            whileStatement.setCondition(JavaParser.parseExpression(WHILE_VARIABLE));
            whileStatement.setBody(switchStatement);

            BlockStmt blockStatement = new BlockStmt();

            for (String d: declarations.get(methods.indexOf(m))) {
                blockStatement.addStatement(JavaParser.parseStatement(d));
            }
            blockStatement.addStatement(JavaParser.parseStatement("int " + SWITCH_SELECTOR + " = 0;"));
            blockStatement.addStatement(JavaParser.parseStatement("boolean " + WHILE_VARIABLE + " = true;"));
            blockStatement.addStatement(whileStatement);
            m.setBody(blockStatement);
            System.out.println(classDec);

        }
    }



}
