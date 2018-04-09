import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.Statement;

import java.util.List;

public interface SwitchingStrategy {
    public final String SWITCH_SELECTOR = "switchOnThis";
    public final String WHILE_VARIABLE = "infiniteLoop";
    public void createSwitchStatement(ClassOrInterfaceDeclaration cls, List<List<Statement>> statements, List<List<Statement>> declarations, List<MethodDeclaration> methods);
}
