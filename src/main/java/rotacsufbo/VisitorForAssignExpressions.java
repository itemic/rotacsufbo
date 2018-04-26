package rotacsufbo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import rotacsufbo.encrypt.Encrypt;

public class VisitorForAssignExpressions extends VoidVisitorAdapter<Object> {

    @Override
    public void visit(AssignExpr n, Object args) {
        if (n.getValue().isStringLiteralExpr()) {
            String originalString  = n.getValue().toString();
            String encryptedString = Encrypt.encryptAll(originalString) ; // sejal
            System.out.println(" ORIGINAL : " + originalString );
            n.setValue(JavaParser.parseExpression("Decrypt.decrypt(\"" + encryptedString + "\")"));
        }

//        if ()
    }

}
