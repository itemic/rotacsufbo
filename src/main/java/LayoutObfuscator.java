import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LayoutObfuscator {

    //TODO: DOES NOT WORK WITH @ANNOTATIONS
    public String IntoALine(File javaSource) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(javaSource));
        StringBuilder oneLineFile = new StringBuilder();
        String line;
        while ((line=br.readLine()) != null) {
            line = line.trim();
            oneLineFile.append(line);
        }
        br.close();
        return oneLineFile.toString();
    }

}
