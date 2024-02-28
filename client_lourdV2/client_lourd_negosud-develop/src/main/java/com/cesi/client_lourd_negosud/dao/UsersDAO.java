package com.cesi.client_lourd_negosud.dao;


import com.cesi.client_lourd_negosud.models.Personnes;
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

public class UsersDAO {
    //méthode pour récupérer tous les clients en string JSON via l'API pour ensuite parse/découper la string en fonction des champs
    public List<Personnes> getAllUsers() {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("http://localhost:29200/api/v1/personnes");
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

    //méthode appelée dans la fonction précédente qui permet de parser la string JSON récupérée via l'API
    private List<Personnes> parseJsonArray(String jsonArray) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonArray, new TypeReference<List<Personnes>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // TODO Gérer les erreurs de parsing ici
            return Collections.emptyList();
        }
    }



    //méthode pour récupérer (read) 1 Client
    public static Personnes getUserById(int id) {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("http://localhost:29200/api/v1/personnes/"+id);
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
        Personnes apiUser = parseJsonString(response.toString());
        return apiUser;
    }

    public static Personnes parseJsonString(String jsonString) {
        try {
            // Utilisation de Jackson ObjectMapper pour mapper la chaîne JSON vers un objet Java
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, Personnes.class);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO Gérer les erreurs de parsing ici
            return null;
        }
    }

    //méthode pour supprimer un client via son id
    public void deleteUsers(int id) {
        try {
            URL url = new URL("http://localhost:29200/api/v1/personnes/"+id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // La suppression a réussi
                System.out.println("Client supprimé avec succès.");
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

