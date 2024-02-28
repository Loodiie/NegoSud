package com.cesi.client_lourd_negosud.dao;

import com.cesi.client_lourd_negosud.models.CommandesClients;
import com.cesi.client_lourd_negosud.models.CommandesMagasin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class CommandesMagasinDAO {
    // Méthode pour récupérer tous les WineOrders en JSON depuis l'API et les convertir en objets WineOrder
    public List<CommandesMagasin> getAllWineOrders() {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("http://localhost:29200/api/v1/commandesMagasin");
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

    // Méthode pour parser le JSON et convertir la réponse en une liste de WineOrder
    private List<CommandesMagasin> parseJsonArray(String jsonArray) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonArray, new TypeReference<List<CommandesMagasin>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // TODO Gérer les erreurs de parsing ici
            return Collections.emptyList();
        }
    }

    // Méthode pour récupérer un WineOrder par son ID
    public CommandesMagasin getWineOrderById(int id) {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("http://localhost:29200/api/v1/commandesMagasin/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
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
        return parseJsonString(response.toString());
    }

    // Méthode pour parser un seul WineOrder à partir de la réponse JSON
    private CommandesMagasin parseJsonString(String jsonString) {
        try { // Utilisation de Jackson ObjectMapper pour mapper la chaîne JSON vers un objet Java
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, CommandesMagasin.class);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO Gérer les erreurs de parsing ici
            return null;
        }
    }

    // Méthode pour supprimer un WineOrder par son ID
    public void deleteWineOrder(int id) {
        try {
            URL url = new URL("http://localhost:29200/api/v1/commandesClients/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // La suppression a réussi
                System.out.println("WineOrder supprimé avec succès.");
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
}
