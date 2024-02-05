package grp.cesi.negosud_javafx;
// MainApp.java
import com.fasterxml.jackson.core.JsonProcessingException;
import grp.cesi.negosud_javafx.model.adresses.Adresses;
import grp.cesi.negosud_javafx.model.articles.Articles;
import grp.cesi.negosud_javafx.model.familles.Familles;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

import static grp.cesi.negosud_javafx.call.*;

public class Main extends Application {

        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 857, 588);
            stage.setTitle("Negosud");
            stage.setScene(scene);
            stage.show();

            TableView<Familles> table = new TableView<Familles>();
            Familles familles = new Familles();
            familles.Deserialize(get("familles",1));
            table.getItems().add(familles);
        }

        public static void main(String[] args) throws JsonProcessingException {
            launch();



        }
}