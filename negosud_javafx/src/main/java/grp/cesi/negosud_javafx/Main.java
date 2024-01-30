package grp.cesi.negosud_javafx;
// MainApp.java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));
        primaryStage.setTitle("NegoSud");
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();;
        // Create a button and a label
        //Button clickButton = new Button("Click Me!");
        //Label outputLabel = new Label("Hello, JavaFX!");

        // Set up event handling for the button
        //clickButton.setOnAction(e -> outputLabel.setText("Button Clicked!"));

        // Create a layout and add the button and label
        //StackPane root = new StackPane();
        //root.getChildren().addAll(clickButton, outputLabel);

        // Create the scene and set it on the stage
        //Scene scene = new Scene(root, 300, 200);
        //primaryStage.setScene(scene);

        // Set the title of the stage and show it
        //primaryStage.setTitle("JavaFX App");
        //primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

