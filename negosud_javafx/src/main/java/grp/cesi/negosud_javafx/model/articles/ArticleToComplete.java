package grp.cesi.negosud_javafx.model.articles;

import com.fasterxml.jackson.core.JsonProcessingException;
import grp.cesi.negosud_javafx.Call;
import grp.cesi.negosud_javafx.model.familles.Familles;
import grp.cesi.negosud_javafx.model.typeVin.TypeVin;

import java.util.ArrayList;
import java.util.Collection;

public class ArticleToComplete {
    public static ArticleComplete ArticleToComplete(Articles article) throws JsonProcessingException {
        ArticleComplete articleComplete = new ArticleComplete();

        Familles familles = new Familles();
        String resultFamilles = Call.get("familles",article.getFamille_id());
        familles = familles.Deserialize(resultFamilles);

        TypeVin typeVin = new TypeVin(0,"");
        String resultTypeVin = Call.get("typeVin",familles.getType_vin());
        typeVin = typeVin.Deserialize(resultTypeVin);

        articleComplete.setArticle_id(article.getArticle_id());
        articleComplete.setTva(article.getTva());
        articleComplete.setReduction(article.getReduction());
        articleComplete.setOffert(article.getOffert());
        articleComplete.setFamille_id(article.getFamille_id());
        articleComplete.setAnnee(familles.getAnnee());
        articleComplete.setFamille_libelle(familles.getLibelle());
        articleComplete.setDegre(familles.getDegre());
        articleComplete.setPrix_unit(familles.getPrix_unit());
        articleComplete.setType_vin(typeVin.getLibelle());


        return articleComplete;
    }

    public static Collection<ArticleComplete> CollecArticlesToComplete(Collection<Articles> collecArticle) throws JsonProcessingException {
        Collection<ArticleComplete> collecComplete = new ArrayList<>();
        for(Articles article : collecArticle){
            collecComplete.add(ArticleToComplete(article));
        }

        return collecComplete;
    }
}
