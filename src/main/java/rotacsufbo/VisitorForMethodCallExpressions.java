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


public class VisitorForMethodCallExpressions extends VoidVisitorAdapter<Object>{

    @Override
    public void visit(MethodCallExpr n, Object args) {
        System.out.println("VIS: " + n.getArguments());

        for (Expression ex: n.getArguments()) {
            if (ex.isStringLiteralExpr()) {
                System.out.println(ex);
                StringLiteralExpr sle = (StringLiteralExpr)ex;
                String original = ex.toString().substring(1, ex.toString().length()-1);
                String encrypted = Encrypt.encryptAll(original); //sejal
                String decryptionExpression = "Decrypt.decrypt(\"" + encrypted + "\")";
                System.out.println("dec:" + decryptionExpression);
                System.out.println("Decrypted: " + Decrypt.decrypt(encrypted));
                System.out.println("Decrypt.decrypt(\"" + encrypted + "\")");
                ex.replace(JavaParser.parseExpression(decryptionExpression));
            } // add elseif int

            List<Node> nodes = ex.getChildNodes();
            for (int i = 0; i < nodes.size(); i++) {
                if (nodes.get(i) instanceof StringLiteralExpr) {
                    String original = nodes.get(i).toString();
                    original = original.substring(1, original.length()-1);
                    String encrypted = Encrypt.encryptAll(original);
                    nodes.get(i).replace(JavaParser.parseExpression("Decrypt.decrypt(\"" + encrypted + "\")"));
                }
            }
        }





//        if ()
    }
}
