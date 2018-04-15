package rotacsufbo;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class Decommentator extends VoidVisitorAdapter<Object>{

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Object args) {
        super.visit(n, args);
        System.out.println(n.getClass());
    }

}
