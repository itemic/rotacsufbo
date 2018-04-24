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

import java.util.List;


public class EncryptingVisitor3 extends VoidVisitorAdapter<Object>{

    @Override
    public void visit(MethodCallExpr n, Object args) {
        System.out.println("VIS: " + n.getArguments());

        for (Expression ex: n.getArguments()) {
            if (ex.isStringLiteralExpr()) {
                System.out.println(ex);
                StringLiteralExpr sle = (StringLiteralExpr)ex;
                String original = ex.toString();
                String encrypted = original; //sejal
                ex.replace(JavaParser.parseExpression("Decryptor.decrypt(" + encrypted + ")"));
            } // add elseif int

            List<Node> nodes = ex.getChildNodes();
            for (int i = 0; i < nodes.size(); i++) {
                if (nodes.get(i) instanceof StringLiteralExpr) {
                    String original = nodes.get(i).toString();
                    String encrypted = original;
                    nodes.get(i).replace(JavaParser.parseExpression("Decryptor.decrypt(" + encrypted + ")"));
                }
            }
        }





//        if ()
    }
}
