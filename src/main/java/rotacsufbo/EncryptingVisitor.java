package rotacsufbo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class EncryptingVisitor extends VoidVisitorAdapter<Object> {

    @Override
    public void visit(VariableDeclarator n, Object args) {


        if (n.getTypeAsString().equals("String")) {
            // convert "STR" to Decryptor.decrypt(ENCRYPTED)

            String originalString = n.getInitializer().get().toString();
            String encryptedString = originalString; // here we encrypt it with sejal

            n.setInitializer(JavaParser.parseExpression("Decryptor.decrypt(" + encryptedString + ")"));

        }

        //TODO: Integers



    }


}
