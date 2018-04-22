package rotacsufbo.view;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import rotacsufbo.*;

import java.io.*;
import java.util.ArrayList;

public class FilesLayoutController {
    private ObservableList<String> sourceFiles;


    @FXML
    private ComboBox<String> filesListComboBox;

    @FXML
    private ListView<String> filesListView;

    @FXML
    private Button doneBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextArea codeTextArea;

    @FXML
    void finish(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/StartLayout.fxml"));
            BorderPane filesPane = (BorderPane)loader.load();
            StartLayoutController controller = loader.<StartLayoutController>getController();
            BorderPane root = Main.getRoot();
            root.setCenter(filesPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize(File dst) {
        FileExplorer fe = new FileExplorer();
        fe.traverseFolder(dst);
        ArrayList<String> shortenedFiles = new ArrayList<>();
        for (File f : fe.getFiles()) {
            shortenedFiles.add(f.toString().substring(dst.toString().length()));
            // OBFUSCATE HERE:

            try {
                CompilationUnit unit = JavaParser.parse(f);
                Obfuscator obfuscator = new Obfuscator(unit);
                obfuscator.decommentate();
                obfuscator.flatten();

                BufferedWriter writer = new BufferedWriter(new FileWriter(f));
                writer.write(obfuscator.getUnit().toString());
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        sourceFiles = FXCollections.observableArrayList(shortenedFiles);

        filesListComboBox.getItems().addAll(sourceFiles);

        filesListComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    BufferedReader in = new BufferedReader(new FileReader(new File(dst + newValue)));
                    String line;
                    StringBuilder sb = new StringBuilder();
                    while ((line = in.readLine()) != null ) {
                        sb.append(line + "\n");
                    }


                    codeTextArea.setText(sb.toString());


                    System.out.println(dst + newValue);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}



