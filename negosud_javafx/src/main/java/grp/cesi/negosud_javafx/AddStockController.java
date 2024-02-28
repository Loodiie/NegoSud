package grp.cesi.negosud_javafx;

import com.fasterxml.jackson.core.JsonProcessingException;
import grp.cesi.negosud_javafx.model.articles.NewArticles;
import grp.cesi.negosud_javafx.model.cartons.Cartons;
import grp.cesi.negosud_javafx.model.cartons.NewCartons;
import grp.cesi.negosud_javafx.model.familles.Familles;
import grp.cesi.negosud_javafx.model.typeVin.TypeVin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class AddStockController implements Initializable {
    @FXML
    private ComboBox combo_famille;
    @FXML
    private ComboBox combo_carton;
    @FXML
    private TextField tva;
    @FXML
    private TextField reduction;
    @FXML
    private TextField offert;
    @FXML
    private TextField fk_commandeM;
    @FXML
    private TextField nbr_bouteilles;
    private Dictionary<String, Integer> dicoFamille = new Hashtable();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        String resultFamille = Call.getAll("familles");
        Familles myFamilleDTO = new Familles();
        Collection<Familles> collecFamilles = new ArrayList<>();
        try {
            collecFamilles = myFamilleDTO.DeserializeAll(resultFamille);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        for (Familles familles : collecFamilles){
            String resultTypeVin = Call.get("typeVin",familles.getType_vin());
            TypeVin mytypeVin = new TypeVin(0,"");
            try {
                mytypeVin = mytypeVin.Deserialize(resultTypeVin);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            combo_famille.getItems().add(mytypeVin.getLibelle() + " - " + familles.getLibelle());
            dicoFamille.put(mytypeVin.getLibelle() + " - " + familles.getLibelle(),familles.getFamille_id());
        }
    }
    @FXML
    protected void onClickAnnuler(){
        Stage actualStage = (Stage) combo_famille.getScene().getWindow();
        actualStage.close();
    }
    @FXML
    protected void onClickEnvoyer() throws JsonProcessingException {

        if (tva.getText().isEmpty() || reduction.getText().isEmpty() || offert.getText().isEmpty() ||
                combo_famille.getValue().equals("Famille") || combo_carton.getValue().equals("Carton") ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez renseigner toutes les cases");
            alert.showAndWait();
        }
        else{
            Cartons cartons = new Cartons(0,"");
            if(combo_carton.getValue().equals("Oui")){
                NewCartons newCartons = new NewCartons();
                newCartons.setDescription("Commande : " + fk_commandeM.getText());
                String bodyCarton = newCartons.Serialize();
                String resultCarton = Call.create("cartons", bodyCarton);
                cartons = cartons.Deserialize(resultCarton);
            }

            NewArticles articles = new NewArticles();
            articles.setTva(Float.parseFloat(tva.getText()));
            articles.setReduction(Float.parseFloat(reduction.getText()));
            articles.setOffert(Integer.parseInt(offert.getText()));
            articles.setCommandesC_id(1);
            articles.setCommandesM_id(Integer.parseInt(fk_commandeM.getText()));
            articles.setCarton_id(cartons.getCarton_id());
            articles.setFamille_id(dicoFamille.get(combo_famille.getValue()));

            String body = articles.Serialize();
            int nombrebouteilles = Integer.parseInt(nbr_bouteilles.getText());
            for(int i=0; i <nombrebouteilles; i++){
                Call.create("articles",body);
            }

            Stage actualStage = (Stage) combo_carton.getScene().getWindow();
            actualStage.close();
        }


    }
}
