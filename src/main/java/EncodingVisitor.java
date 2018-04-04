import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Base64;

public class EncodingVisitor extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(MethodDeclaration n, Void arg) {
        String encoded = Base64.getEncoder().encodeToString(n.getNameAsString().getBytes());
        n.setName(encoded);
    }

}
