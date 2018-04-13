package rotacsufbo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LayoutObfuscator {

    //TODO: DOES NOT WORK WITH @ANNOTATIONS
    public String intoALine(File javaSource) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(javaSource));
        StringBuilder oneLineFile = new StringBuilder();
        String line;
        while ((line=br.readLine()) != null) {
            line = line.trim();
            if (line.length() > 0 && line.charAt(0) == '@') {
                oneLineFile.append(System.lineSeparator() + line + System.lineSeparator());
            } else {
                oneLineFile.append(line);
            }
        }
        br.close();
        return oneLineFile.toString();
    }



}
