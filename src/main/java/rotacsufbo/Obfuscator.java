package rotacsufbo;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

public class Obfuscator {

    private CompilationUnit unit;

    public Obfuscator(CompilationUnit unit) {
        this.unit = unit;
    }

    /**
     * Flatten ALL classes in this compilation unit
     */
    public void flatten() {
        for (ClassOrInterfaceDeclaration cls: unit.findAll(ClassOrInterfaceDeclaration.class)) {
            Flattener flattener = new Flattener(cls);
            flattener.createStatements();
            flattener.createSwitch();
        }
    }

    public void decommentate() {
        Decommentator decommentator = new Decommentator();
        unit.accept(new Decommentator(), null);
    }

    public void encryptConstants() {
        // lol do nothing
    }

    public CompilationUnit getUnit() {
        return unit;
    }
}
