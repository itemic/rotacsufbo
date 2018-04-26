package rotacsufbo;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import java.io.*;

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

    public void encryptStrings() {
        // lol do nothing
        unit.accept(new VisitorForMethodCallExpressions(), null);
        unit.accept(new VisitorForVariableDeclarators(), null);
        unit.accept(new VisitorForAssignExpressions(), null);
    }

    public void insertDecryptor() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Terran\\Projects\\rotacsufbo\\src\\main\\java\\rotacsufbo\\encrypt\\Decrypt.java"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:\\Users\\Terran\\Projects\\decrypt.java")));

            String line = null;
            while ((line=reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CompilationUnit getUnit() {
        return unit;
    }
}
