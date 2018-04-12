package rotacsufbo;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class EncodingVisitor extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(MethodDeclaration n, Void arg) {
//        String encoded = Base64.getEncoder().encodeToString(n.getNameAsString().getBytes());
        String encoded = EvilEncoder.encode(n.getNameAsString());
        n.setName(encoded);
    }

}
