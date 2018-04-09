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
//TODO: Numbering strategies

public class ClassFlattener {
    private ClassOrInterfaceDeclaration classDec;
    private SwitchingStrategy strategy;

    private List<MethodDeclaration> methods;
    private List<List<Statement>> statements = new ArrayList<>();
    private List<List<Statement>> declarations = new ArrayList<>();
    public final String SWITCH_SELECTOR = "switchOnThis";
    public final String WHILE_VARIABLE = "infiniteLoop";

    public ClassFlattener(ClassOrInterfaceDeclaration cls) {
        classDec = cls;
        methods = cls.getMethods();
        strategy = new UUIDSwitchingStrategy();
    }

    public void createStatements() {
        for (MethodDeclaration m: methods) {
            // Create statement/declaration lists
            List<Statement> statement = new ArrayList<>();
            List<Statement> declaration = new ArrayList<>();

            Optional<BlockStmt> body = m.getBody();
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
        this.strategy.createSwitchStatement(classDec, statements, declarations, methods);
    }



}
