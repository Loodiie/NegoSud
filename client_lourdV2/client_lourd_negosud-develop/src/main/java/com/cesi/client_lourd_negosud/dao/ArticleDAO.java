package com.cesi.client_lourd_negosud.dao;

import com.cesi.client_lourd_negosud.models.Articles;
import com.cesi.client_lourd_negosud.models.Familles;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class ArticleDAO {

    public static Familles getArticleById(int id) {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("http://localhost:29200/api/v1/familles/"+id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // On spécifie l'encodage UTF-8 lors de la création de InputStreamReader pour que les accents soient gérés et s'affichent bien dans le client lourd
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                response.append("Erreur de réponse de l'API. Code : ").append(responseCode);
            }


        } catch (IOException e) {
            e.printStackTrace();
            response.append("Erreur lors de l'appel de l'API : ").append(e.getMessage());
        }
        Familles apiArticles = parseJsonString(response.toString());
        return apiArticles;
    }

    public List<Familles> getAllArticles() {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("http://localhost:29200/api/v1/familles");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // On spécifie l'encodage UTF-8 lors de la création de InputStreamReader pour que les accents soient gérés et s'affichent bien dans le client lourd
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                response.append("Erreur de réponse de l'API. Code : ").append(responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
            response.append("Erreur lors de l'appel de l'API : ").append(e.getMessage());
        }

        return parseJsonArray(response.toString());
    }

    //méthode pas encore opérationnelle et à modifier
    /*public void postArticle(Article article) {
        try {
            URL url = new URL("http://localhost:29200/api/v1/articles");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Définir la méthode de requête sur "POST"
            connection.setRequestMethod("POST");
            // Activer l'envoi de données
            connection.setDoOutput(true);

            connection.setRequestProperty("Content-Type", "application/json");

            //On feed l'objet = transformer l'objet en objet de sortie attendu par la bdd/l'API
            article.setIdSupplier(article.getSupplier().getIdSupplier());
            // Créer une chaîne JSON à partir de l'objet Article
            String jsonString = convertObjectToJsonString(article);

            // Écrire les données dans le flux de sortie
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(jsonString.getBytes(StandardCharsets.UTF_8));
            out.flush();


            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                // La création a réussi, gérer la réponse si nécessaire
                System.out.println("Article créé avec succès.");
            } else {
                System.out.println("Erreur de réponse de l'API. Code : " + responseCode);
            }

            // Fermer la connexion
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs ici
        }

    }*/

    public void deleteArticle(int articleId) {
        try {
            URL url = new URL("http://localhost:29200/api/v1/familles/"+articleId);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // On définit la méthode de requête sur "DELETE"
            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // La suppression a réussi
                System.out.println("Article supprimé avec succès.");
            } else {
                System.out.println("Erreur de réponse de l'API. Code : " + responseCode);
            }

            // Ferme la connexion
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
            // TODO Gérer les erreurs ici
        }

    }


    private List<Familles> parseJsonArray(String jsonArray) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonArray, new TypeReference<List<Familles>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // TODO Gérer les erreurs de parsing ici
            return Collections.emptyList();
        }
    }

    public static Familles parseJsonString(String jsonString) {
        try {
            // Utilisation de Jackson ObjectMapper pour mapper la chaîne JSON vers un objet Java
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, Familles.class);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO Gérer les erreurs de parsing ici
            return null;
        }
    }

    //méthode qui nous servira peut être pour les POST et les PUT
    /*public static String convertObjectToJsonString(Article article) {
        try {
            // Utilisation de Jackson ObjectMapper pour convertir l'objet en chaîne JSON
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(article);
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs de conversion ici
            return null;
        }
    }*/

    public Map<Integer, BigDecimal> getStocksByArticle() {
        // Créer une map pour stocker les quantités en stock par article
        Map<Integer, BigDecimal> stocksByArticle = new HashMap<>();

        try {
            // Créer une URL pour l'API de récupération des stocks par article
            URL url = new URL("http://localhost:29200/articles/stocks");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Vérifier si la réponse est OK
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Récupérer la réponse de l'API
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Convertir la réponse JSON en objet Map
                ObjectMapper objectMapper = new ObjectMapper();
                Map<Integer, BigDecimal> apiResponse = objectMapper.readValue(response.toString(), new TypeReference<Map<Integer, BigDecimal>>() {});

                // Mettre à jour la map des stocks par article
                stocksByArticle.putAll(apiResponse);
            } else {
                System.out.println("Erreur lors de la récupération des stocks par article. Code : " + connection.getResponseCode());
            }

            // Fermer la connexion
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération des stocks par article : " + e.getMessage());
        }

        return stocksByArticle;
    }

}
