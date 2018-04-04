import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        System.out.println("b");
        FileExplorer fe = new FileExplorer();
        // can we make it so we don't specify this??
        File root = new File("/Users/terran/Desktop/testfile");
        fe.traverseFolder(root);
        for (File f: fe.getFiles()) {
            System.out.println(f.getName());
            CompilationUnit unit = JavaParser.parse(f);

            unit.accept(new EncodingVisitor(), null);
            unit.accept(new RenamingVisitor(), null);

            // experiment with adding random generated comments
            unit.findAll(FieldDeclaration.class).stream().forEach(
                    c -> {
                        c.setComment(new LineComment("this is actually very important!"));
                    }
            );
            System.out.println(unit);
        }

    }



}
