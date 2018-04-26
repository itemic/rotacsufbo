package rotacsufbo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import rotacsufbo.encrypt.Decrypt;
import rotacsufbo.encrypt.Encrypt;

import java.util.List;


/**
 * Go through method call expressions to find Strings which are parameters
 * and encrypt them
 */
public class VisitorForMethodCallExpressions extends VoidVisitorAdapter<Object>{

    @Override
    public void visit(MethodCallExpr n, Object args) {
        for (Expression ex: n.getArguments()) {
            if (ex.isStringLiteralExpr()) {

                // Only strip the edges if they are quotes because some may be literals
                if (ex.toString().charAt(0) == '"' && ex.toString().charAt(ex.toString().length()-1) == '"') {
                    String original = ex.toString().substring(1, ex.toString().length()-1);
                    String encrypted = Encrypt.encryptAll(original); //sejal
                    String decryptionExpression = "Decrypt.decrypt(\"" + encrypted + "\")";
                    ex.replace(JavaParser.parseExpression(decryptionExpression));
                }
            }

            // Go through children as well
            List<Node> nodes = ex.getChildNodes();
            for (int i = 0; i < nodes.size(); i++) {
                if (nodes.get(i) instanceof StringLiteralExpr) {
                    String original = nodes.get(i).toString();
                    if (original.charAt(0) == '"' && original.charAt(original.length()-1) == '"') {
                        original = original.substring(1, original.length()-1);
                        String encrypted = Encrypt.encryptAll(original);
                        nodes.get(i).replace(JavaParser.parseExpression("Decrypt.decrypt(\"" + encrypted + "\")"));
                    }
                }
            }
        }

    }
}
