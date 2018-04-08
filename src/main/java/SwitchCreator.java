import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.stmt.*;
import com.sun.org.apache.xpath.internal.operations.Variable;
import com.sun.tools.javap.JavapFileManager;
import javafx.embed.swt.SWTFXUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SwitchCreator {
    // RIGHT NOW ONLY WORKS FOR CLASSES WITH SINGLE METHODS!
    List<String> statements = new ArrayList<>();
    List<String> declarators = new ArrayList<>();

    public void collectStatements(CompilationUnit unit) {
        List<ClassOrInterfaceDeclaration> decs = unit.findAll(ClassOrInterfaceDeclaration.class);
        for (ClassOrInterfaceDeclaration cls : decs) {
            List<MethodDeclaration> methods = cls.getMethods();
            for (MethodDeclaration m : methods) {
                System.out.println(m.getNameAsString());
                Optional<BlockStmt> body = m.getBody();
                NodeList<Statement> stmts = body.get().getStatements();
                for (Statement s: stmts) {
                    //Check if statement has a variable declarator
                    List<VariableDeclarator> varDeclarators = s.findAll(VariableDeclarator.class);
                    if (varDeclarators.isEmpty()) {
                        statements.add(s.toString());
                    } else {
                        for (VariableDeclarator v: varDeclarators) {
                            String initialization = v.getType() + " " + v.getName() + " = 0;"; // fake init
                            declarators.add(initialization);
                            statements.add(v.toString() + ";");
                        }
                    }
                }
            }
        }
    }

    public void createSwitch(CompilationUnit cu) {
        List<ClassOrInterfaceDeclaration> decs = cu.findAll(ClassOrInterfaceDeclaration.class);
        for (ClassOrInterfaceDeclaration c: decs) {
            List<MethodDeclaration> methods = c.getMethods();
            for (MethodDeclaration m: methods) {
                SwitchStmt s = new SwitchStmt();
                s.setSelector(JavaParser.parseExpression("switcherStatement"));
                NodeList<SwitchEntryStmt> entries = new NodeList<>();
                int switchCount = 0;

                for (String st: statements) {
                    SwitchEntryStmt entry = new SwitchEntryStmt();
                    NodeList<Statement> entryStatements = new NodeList<>();
                    System.out.println(st);
                    entry.setLabel(JavaParser.parseExpression(switchCount + ""));
                    switchCount++;
                    entryStatements.add(JavaParser.parseStatement(st));
                    entryStatements.add(JavaParser.parseStatement("switcherStatement++;"));
                    entryStatements.add(JavaParser.parseStatement("break;"));
                    entry.setStatements(entryStatements);
                    entries.add(entry);
                }


                NodeList<Statement> defaultSwitch = new NodeList<>();
                defaultSwitch.add(JavaParser.parseStatement("switchKeeper = false;"));
                entries.add(new SwitchEntryStmt(null, defaultSwitch));
                s.setEntries(entries);

                WhileStmt ws = new WhileStmt();
                ws.setCondition(JavaParser.parseExpression("switchKeeper"));
                ws.setBody(s);
                BlockStmt bs = new BlockStmt();
                for (String dec: declarators) {
                    bs.addStatement(JavaParser.parseStatement(dec));
                }
                bs.addStatement(JavaParser.parseStatement("int switcherStatement = 0;"));
                bs.addStatement(JavaParser.parseStatement("boolean switchKeeper = true;"));
                bs.addStatement(ws);
                m.setBody(bs);
                System.out.println(cu);
            }
        }
    }
}
