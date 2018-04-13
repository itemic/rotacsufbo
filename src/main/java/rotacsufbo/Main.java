package rotacsufbo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import rotacsufbo.view.StartLayoutController;

import java.io.File;
import java.io.IOException;

public class Main extends Application{

    private Stage primaryStage;
    private static BorderPane rootLayout;

    public static void main(String[] args) {
        FileExplorer fe = new FileExplorer();
        // can we make it so we don't specify this??
        File root = new File("C:\\Users\\Terran\\IdeaProjects\\Bepis\\src\\rotacsufbo.Main.java");
        fe.traverseFolder(root);
//        for (File f : fe.getFiles()) {
//            System.out.println(f.getName());
//            CompilationUnit unit = JavaParser.parse(f);
//
//            for(ClassOrInterfaceDeclaration cls: unit.findAll(ClassOrInterfaceDeclaration.class)) {
//                rotacsufbo.ClassFlattener cf = new rotacsufbo.ClassFlattener(cls);
//                cf.createStatements();
//                cf.createSwitch();
//            }

//            System.out.println(unit);
//        }

        OpaquePredator op = new OpaquePredator();
        System.out.println(op.makeTrueExpression("bepis"));

        launch(args);
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
