package rotacsufbo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import rotacsufbo.encrypt.Encrypt;

/**
 * Go through assignment expressions to encrypt strings.
 */
public class VisitorForAssignExpressions extends VoidVisitorAdapter<Object> {

    @Override
    public void visit(AssignExpr n, Object args) {
        if (n.getValue().isStringLiteralExpr()) {
            String originalString  = n.getValue().toString();
            if (originalString.charAt(0) == '"' && originalString.charAt(originalString.length()-1) == '"') {
                originalString = originalString.substring(1, originalString.length()-1);
                String encryptedString = Encrypt.encryptAll(originalString);
                n.setValue(JavaParser.parseExpression("Decrypt.decrypt(\"" + encryptedString + "\")"));
            }

        }
    }

}
