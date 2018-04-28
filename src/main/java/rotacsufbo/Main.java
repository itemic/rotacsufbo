package rotacsufbo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import rotacsufbo.view.StartLayoutController;

import java.io.*;
import java.util.ArrayList;

/**
 * Entry point and GUI setup code
 */
public class Main extends Application{

    private Stage primaryStage;
    private static BorderPane rootLayout;

    public static void main(String[] args) throws IOException {

        launch(args);

        // Uncomment this to oneline files.
//        File f = new File("C:\\Users\\Terran\\Projects\\FindFood");
//        FileExplorer fe = new FileExplorer();
//        fe.traverseFolder(f);
//        for (File file: fe.getFiles()) {
//            String oneLined = LayoutObfuscator.intoALine(file);
//
//            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//            writer.write(oneLined);
//            writer.close();
//        }

    }


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Rotacsufbo");
        initLayout();
        showStartScreen();

    }

    public void initLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStartScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/StartLayout.fxml"));
            BorderPane startLayout = loader.load();
            StartLayoutController controller = loader.getController();
            rootLayout.setCenter(startLayout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BorderPane getRoot() {
        return rootLayout;
    }
}
