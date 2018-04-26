package rotacsufbo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import rotacsufbo.encrypt.Encrypt;

public class VisitorForVariableDeclarators extends VoidVisitorAdapter<Object> {

    @Override
    public void visit(VariableDeclarator n, Object args) {


        if (n.getTypeAsString().equals("String")) {
            // convert "STR" to Decryptor.decrypt(ENCRYPTED)

            String originalString = n.getInitializer().get().toString();
            String encryptedString = Encrypt.encryptAll(originalString); // here we encrypt it with sejal
            System.out.println("Decrypt.decrypt(\"" + encryptedString + "\")");

            n.setInitializer(JavaParser.parseExpression("Decrypt.decrypt(\"" + encryptedString + "\")"));

        }

        //TODO: Integers



    }


}
