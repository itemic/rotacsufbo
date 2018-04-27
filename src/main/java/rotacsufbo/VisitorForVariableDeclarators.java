package rotacsufbo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import rotacsufbo.encrypt.Encrypt;

import java.util.Optional;

/**
 * Visit and encrypt variable declarators (e.g. String b = "value")
 */
public class VisitorForVariableDeclarators extends VoidVisitorAdapter<Object> {

    @Override
    public void visit(VariableDeclarator n, Object args) {


        if (n.getTypeAsString().equals("String")) {
            Optional<Expression> init = n.getInitializer();
            // Ensure that there's an initializer
            if (init.isPresent()) {
                String originalString = n.getInitializer().get().toString();
                if (originalString.charAt(0) == '"' && originalString.charAt(originalString.length()-1) == '"') {
                    originalString = originalString.substring(1, originalString.length()-1);
                    String encryptedString = Encrypt.encryptAll(originalString);
                    n.setInitializer(JavaParser.parseExpression("Decrypt.decrypt(\"" + encryptedString + "\")"));
                }
            }
        }
    }
}
