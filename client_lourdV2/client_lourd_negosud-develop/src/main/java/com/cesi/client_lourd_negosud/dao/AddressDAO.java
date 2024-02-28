package com.cesi.client_lourd_negosud.dao;

import com.cesi.client_lourd_negosud.models.Adresses;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class AddressDAO {

    public static Adresses getAddressById(int id) {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("http://localhost:29200/api/v1/adresses/"+id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
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
        Adresses apiAddress = parseJsonString(response.toString());
        return apiAddress;
    }

    public List<Adresses> getAllAddress() {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("http://localhost:29200/api/v1/adresses");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
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

    public void deleteAddress(int addressId) {
        try {
            URL url = new URL("http://localhost:29200/api/v1/addresses/"+addressId);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Définir la méthode de requête sur "DELETE"
            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // La création a réussi, gérer la réponse si nécessaire
                System.out.println("Address supprimé avec succès.");
            } else {
                System.out.println("Erreur de réponse de l'API. Code : " + responseCode);
            }

            // Fermer la connexion
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs ici
        }

    }


    private List<Adresses> parseJsonArray(String jsonArray) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonArray, new TypeReference<List<Adresses>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer les erreurs de parsing ici
            return Collections.emptyList();
        }
    }

    public static Adresses parseJsonString(String jsonString) {
        try {
            // Utilisation de Jackson ObjectMapper pour mapper la chaîne JSON vers un objet Java
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, Adresses.class);
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs de parsing ici
            return null;
        }
    }

    public static String convertObjectToJsonString(Adresses address) {
        try {
            // Utilisation de Jackson ObjectMapper pour convertir l'objet en chaîne JSON
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(address);
        } catch (Exception e) {
            e.printStackTrace();
            // Gérer les erreurs de conversion ici
            return null;
        }
    }

}
