package rotacsufbo;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.Statement;

import java.util.List;

public interface SwitchingStrategy {
    String SWITCH_SELECTOR = "switchOnThis";
    String WHILE_VARIABLE = "infiniteLoop";
    void createSwitchStatement(ClassOrInterfaceDeclaration cls, List<List<Statement>> statements, List<List<Statement>> declarations, List<MethodDeclaration> methods);
}
