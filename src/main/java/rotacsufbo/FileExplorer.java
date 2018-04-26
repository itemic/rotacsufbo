package rotacsufbo;

import java.io.File;
import java.util.ArrayList;

/**
 * Helper class to go through all files to find Java files
 */
public class FileExplorer {
    private ArrayList<File> files = new ArrayList<>();

    public void traverseFolder(File f) {
        // Check if current file is a folder or file
        if (f.isDirectory()) { // recursively traverse directories
            for (File file: f.listFiles()) {
                traverseFolder(file);
            }
        } else {
            if (f.getName().endsWith(".java")) {
                files.add(f);
            }
        }
    }

    public ArrayList<File> getFiles() {
        return files;
    }
}
