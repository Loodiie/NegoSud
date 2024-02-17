package grp.cesi.negosud_javafx;
// MainApp.java
import com.fasterxml.jackson.core.JsonProcessingException;
import grp.cesi.negosud_javafx.model.adresses.Adresses;
import grp.cesi.negosud_javafx.model.articles.Articles;
import grp.cesi.negosud_javafx.model.familles.Familles;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collection;

import static grp.cesi.negosud_javafx.call.*;



public class Main extends Application {

    @FXML
    private TableView<Adresses> table;
    @FXML
    private TableColumn<Adresses, Integer> adresse_id;
    @FXML
    private TableColumn<Adresses, String> numero;
    @FXML
    private TableColumn<Adresses, String> rue;
    @FXML
    private TableColumn<Adresses, String> ville;

    @FXML
    private void initialize() throws JsonProcessingException {
        adresse_id.setCellValueFactory(new PropertyValueFactory<Adresses, Integer>("adresse_id"));
        numero.setCellValueFactory(new PropertyValueFactory<Adresses, String>("numero"));
        rue.setCellValueFactory(new PropertyValueFactory<Adresses, String>("rue"));
        ville.setCellValueFactory(new PropertyValueFactory<Adresses, String>("ville"));

        Adresses myadresse = new Adresses();
        String result = getAll("adresses");
        Collection<Adresses> ColecAdresses = myadresse.DeserializeAll(result);

        for (Adresses adresse: ColecAdresses) {
            table.getItems().add(adresse);
        }
    }
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 857, 588);
        stage.setTitle("Negosud");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws JsonProcessingException {
        /*Adresses adresses = new Adresses();
        String result = get("adresses",1);
        adresses = adresses.Deserialize(result);
        adresse_id.setCellValueFactory(new PropertyValueFactory<Adresses, String>(Integer.toString(adresses.getAdresse_id())));
        table.getItems().add(adresses);*/

        //ObservableList<Adresses> table
        launch();



    }
}