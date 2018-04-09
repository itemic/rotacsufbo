import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.*;

import java.util.List;

public class IncrementingSwitchingStrategy implements SwitchingStrategy {
    @Override
    public void createSwitchStatement(ClassOrInterfaceDeclaration cls, List<List<Statement>> statements, List<List<Statement>> declarations, List<MethodDeclaration> methods) {
        for (MethodDeclaration m : methods) {
            SwitchStmt switchStatement = new SwitchStmt();
            switchStatement.setSelector(JavaParser.parseExpression(SWITCH_SELECTOR));
            NodeList<SwitchEntryStmt> entries = new NodeList<>();
            // This value can be changed based on the strategy of randomization
            int switchToValue = 0;

            for (Statement stmt : statements.get(methods.indexOf(m))) {
                SwitchEntryStmt entry = new SwitchEntryStmt();
                NodeList<Statement> entryStatements = new NodeList<>();
                System.out.println("parsing: " + switchToValue);

                entry.setLabel(JavaParser.parseExpression(switchToValue + ""));
                switchToValue++;

                entryStatements.add(stmt);
                System.out.println("Adding: " + stmt + stmt.isReturnStmt());

                // Compiler will pick up dead code if there's something after a return;
                if (!stmt.isReturnStmt()) {
                    entryStatements.add(JavaParser.parseStatement(SWITCH_SELECTOR + "++;"));
                    entryStatements.add(JavaParser.parseStatement("break;"));
                }


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

            for (Statement d : declarations.get(methods.indexOf(m))) {
                blockStatement.addStatement(d);
            }
            blockStatement.addStatement(JavaParser.parseStatement("int " + SWITCH_SELECTOR + " = 0;"));
            blockStatement.addStatement(JavaParser.parseStatement("boolean " + WHILE_VARIABLE + " = true;"));
            blockStatement.addStatement(whileStatement);


            // Have to return something otherwise it will be upset!
            if (!m.getTypeAsString().equals("void")) {
                String returnNothing = "return " + DefaultsHelper.getDefault(m.getTypeAsString()) + ";";
                blockStatement.addStatement(JavaParser.parseStatement(returnNothing));
            }

            m.setBody(blockStatement);
            System.out.println(cls);
        }
    }
}
