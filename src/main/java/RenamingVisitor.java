import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.ModifierVisitor;

import java.util.Base64;

public class RenamingVisitor extends ModifierVisitor<Void> {
    @Override
    public FieldDeclaration visit(FieldDeclaration n, Void arg) {
        super.visit(n, arg);
        n.getVariables().forEach( v -> {
            v.getInitializer().ifPresent(i -> {
                v.setInitializer(Base64.getEncoder().encodeToString(i.toString().getBytes())); //ok but won't work if the thing isn't a string rn!
            });
        });
        return n;
    }
}
