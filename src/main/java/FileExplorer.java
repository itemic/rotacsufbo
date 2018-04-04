import java.io.File;
import java.util.ArrayList;

public class FileExplorer {
    private ArrayList<File> files = new ArrayList<>();

    public void traverseFolder(File f) {
        // Check if current file is a folder or file
        if (f.isDirectory()) {
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
