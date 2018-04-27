package rotacsufbo;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.BlockComment;
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
        kill(childNodes); // visit and go through nodes to add them to list to remove
        for (Node child: nodeCollection) {
            child.remove(); // remove the nodes that have been collected
        }

    }

    /**
     * Iterate through node list to prepare them from removal
     * @param nodes
     */
    private void kill(List<Node> nodes) {
        for(Node node: nodes) {
            kill(node);
        }
    }


    /**
     * Remove comment nodes by adding any of them to a list.
     * @param n Node to remove comments from
     */
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
