package rotacsufbo;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import java.io.*;

/**
 * Main obfuscator class that takes a compilation unit and performs javaparser activities
 * on it to alter the actual CU.
 */
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

    /**
     * Removes all comments
     */
    public void decommentate() {
        unit.accept(new Decommentator(), null);
    }

    /**
     * Go through and change all Strings into decryption strings
     */
    public void encryptStrings() {

        unit.accept(new VisitorForMethodCallExpressions(), null);
        unit.accept(new VisitorForVariableDeclarators(), null);
        unit.accept(new VisitorForAssignExpressions(), null);
    }


    public CompilationUnit getUnit() {
        return unit;
    }
}
