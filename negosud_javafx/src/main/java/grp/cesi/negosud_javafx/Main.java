package grp.cesi.negosud_javafx;
// MainApp.java
import com.fasterxml.jackson.core.JsonProcessingException;
import grp.cesi.negosud_javafx.model.adresses.Adresses;
import grp.cesi.negosud_javafx.model.adresses.NewAdresses;
import grp.cesi.negosud_javafx.model.articles.ArticleComplete;
import grp.cesi.negosud_javafx.model.articles.ArticleToComplete;
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

import static grp.cesi.negosud_javafx.Call.getAll;



public class Main extends Application {

    @FXML
    private TableView<ArticleComplete> table;
    @FXML
    private TableColumn<ArticleComplete, Integer> article_id;
    @FXML
    private TableColumn<ArticleComplete, String> libelle;
    @FXML
    private TableColumn<ArticleComplete, String> type_vin;
    @FXML
    private TableColumn<ArticleComplete, Float> tva;
    @FXML
    private TableColumn<ArticleComplete, Float> reduction;
    @FXML
    private TableColumn<ArticleComplete, Integer> offert;
    @FXML
    private TableColumn<ArticleComplete, Integer> annee;

    @FXML
    private void initialize() throws JsonProcessingException {
        article_id.setCellValueFactory(new PropertyValueFactory<ArticleComplete, Integer>("article_id"));
        libelle.setCellValueFactory(new PropertyValueFactory<ArticleComplete, String>("famille_libelle"));
        type_vin.setCellValueFactory(new PropertyValueFactory<ArticleComplete, String>("type_vin"));
        tva.setCellValueFactory(new PropertyValueFactory<ArticleComplete, Float>("tva"));
        reduction.setCellValueFactory(new PropertyValueFactory<ArticleComplete, Float>("reduction"));
        offert.setCellValueFactory(new PropertyValueFactory<ArticleComplete, Integer>("offert"));
        annee.setCellValueFactory(new PropertyValueFactory<ArticleComplete, Integer>("annee"));

        updateTableView();

        NewAdresses myNewAdresse2 = new NewAdresses("Brest", "29200","france", "12", "rue du chien", null, null, null);
        String body = myNewAdresse2.Serialize();
        System.out.println(body);
        Call.create("adresses",body);
        //System.out.println(get("adresses", 32));
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

    @FXML
    protected void onClickCreate(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add-stock.fxml"));
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(loader.load()));
            stage2.setTitle("Ajouter");
            stage2.setResizable(false);
            stage2.showAndWait();
            updateTableView();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void updateTableView() throws JsonProcessingException {
        table.getItems().clear();

        Articles myarticle = new Articles();
        String result = getAll("articles");
        Collection<Articles> collecArticles = myarticle.DeserializeAll(result);
        Collection<ArticleComplete> collecComplete = ArticleToComplete.CollecArticlesToComplete(collecArticles);

        for (ArticleComplete articleComlete: collecComplete) {
            table.getItems().add(articleComlete);
        }
    }
}