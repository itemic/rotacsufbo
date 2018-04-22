package rotacsufbo;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

public class Decommentator extends VoidVisitorAdapter<Object>{
    private ArrayList<Node> nodeCollection = new ArrayList<>();

    @Override
    public void visit(CompilationUnit n, Object args) {
        super.visit(n, args);
        List<Node> childNodes = n.getChildNodes();
        kill(childNodes);
        System.out.println("A custom string" + n.toString());
        for (Node child: nodeCollection) {
            child.remove();
        }
//        n.setComment(new LineComment(""));

    }

    private void kill(List<Node> nodes) {
        for(Node node: nodes) {
            kill(node);
        }
    }


    private void kill(Node n) {
        n.removeComment();
        for (Node child: n.getChildNodes()) {
            if (child.getClass() == BlockComment.class || child.getClass() == LineComment.class || child.getClass() == JavadocComment.class) {
                nodeCollection.add(child);
            } else {
                kill(child);
            }
        }
    }

}
