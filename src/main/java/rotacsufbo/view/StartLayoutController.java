package rotacsufbo.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import rotacsufbo.FileExplorer;
import rotacsufbo.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartLayoutController implements Initializable{
    private File sourceFileOrDirectory;
    private File exportFileOrDirectory;

    @FXML
    private Label srcFileLabel;

    @FXML
    private Button sourceFilePickerBtn;

    @FXML
    private Label exportFileLabel;

    @FXML
    private Button exportFilePickerBtn;

    @FXML
    private Button nextStepBtn;


    @FXML
    public void selectSourceFile() {
        DirectoryChooser dc = new DirectoryChooser();
        sourceFileOrDirectory = dc.showDialog(new Stage());
        if (sourceFileOrDirectory != null) {
            srcFileLabel.setText(sourceFileOrDirectory.getPath());
            if (exportFileOrDirectory != null) nextStepBtn.setDisable(false);
        } else {
            nextStepBtn.setDisable(true);
        }

    }

    @FXML
    public void selectExportFile() {
        DirectoryChooser dc = new DirectoryChooser();
        exportFileOrDirectory = dc.showDialog(new Stage());
        if (exportFileOrDirectory != null) {
            exportFileLabel.setText(exportFileOrDirectory.getPath());
            if (sourceFileOrDirectory != null) nextStepBtn.setDisable(false);
        } else {
            nextStepBtn.setDisable(true);
        }

    }

    @FXML
    public void confirmFiles() {
        if (exportFileOrDirectory != null && sourceFileOrDirectory != null) {
            if (exportFileOrDirectory.getPath().equals(sourceFileOrDirectory.getPath())) {
                // don't do this, it's overwriting!
                System.out.println("BAD");
            } else {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("view/FilesLayout.fxml"));
                    BorderPane filesPane = (BorderPane)loader.load();
                    FilesLayoutController controller = loader.<FilesLayoutController>getController();
                    controller.initialize(sourceFileOrDirectory, exportFileOrDirectory);
                    BorderPane root = Main.getRoot();
                    root.setCenter(filesPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                System.out.println("GOOD");
//                FileExplorer fe = new FileExplorer();
//                fe.traverseFolder(sourceFileOrDirectory);
//                System.out.println("top level @: " + exportFileOrDirectory.getName());
//                for (File f: fe.getFiles()) {
//                    System.out.println("FILE: " + f);
//                    // so we can preserve folder structure!
//                    System.out.println(f.toString().substring(sourceFileOrDirectory.toString().length()));
//                    //TODO: preserve folder structure
//                    //TODO: actually this stuff will be done in the other controller but for now this is fine :)
                }
                System.out.println("BEP");



            }
        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nextStepBtn.setDisable(true);
    }

}
