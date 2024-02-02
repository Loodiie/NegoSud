package grp.cesi.negosud_javafx;
// MainApp.java
import grp.cesi.negosud_javafx.model.adresses.Adresses;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static grp.cesi.negosud_javafx.call.*;

public class Main extends Application {

        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 857, 588);
            stage.setTitle("Negosud");
            //stage.setScene(scene);
            stage.show();
            stage.setScene(new Scene(new Group()));
            Adresses adresse = new Adresses();
            adresse = adresse.Deserialize(get("adresses",11));
            System.out.println(adresse.getAdresse_id());
        }

        public static void main(String[] args) {
            launch();
        }
}