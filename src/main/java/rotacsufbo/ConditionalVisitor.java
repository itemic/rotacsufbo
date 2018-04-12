package rotacsufbo;

import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ConditionalVisitor extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(IfStmt n, Void v) {
//        System.out.println(n);
//        System.out.println("---------------");
//        System.out.println(n.getCondition());
//        System.out.println("---------------");
//        System.out.println(n.getThenStmt());
//        System.out.println("---------------");
//        System.out.println(n.getElseStmt());
//        System.out.println("---------------");
//        System.out.println(n.getMetaModel());
//        System.out.println("---------------");
        System.out.println("IF STMT: " + n.getBegin());
    }
}
