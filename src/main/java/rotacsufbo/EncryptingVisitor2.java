package rotacsufbo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class EncryptingVisitor2 extends VoidVisitorAdapter<Object> {

    @Override
    public void visit(AssignExpr n, Object args) {
        if (n.getValue().isStringLiteralExpr()) {
            String originalString  = n.getValue().toString();
            String encryptedString = originalString ; // sejal
            System.out.println(" ORIGINAL : " + originalString );
            n.setValue(JavaParser.parseExpression("Decryptor.decrypt(" + encryptedString + ")"));
        }

//        if ()
    }

}
