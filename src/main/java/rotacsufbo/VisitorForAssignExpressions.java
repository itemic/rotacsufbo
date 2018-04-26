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
            System.out.println(originalString);
            if (originalString.charAt(0) == '"' && originalString.charAt(originalString.length()-1) == '"') {
                originalString = originalString.substring(1, originalString.length()-1);
                String encryptedString = Encrypt.encryptAll(originalString) ; // sejal
                System.out.println(" ORIGINAL : " + originalString );
                n.setValue(JavaParser.parseExpression("Decrypt.decrypt(\"" + encryptedString + "\")"));
            } else {
                System.out.println("skipping over " + originalString);
            }

        }

//        if ()
    }

}
