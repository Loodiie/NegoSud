package com.cesi.client_lourd_negosud.dao;

import com.cesi.client_lourd_negosud.models.NewTypeVin;
import com.cesi.client_lourd_negosud.models.TypeVin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class FamilyDAO {

    //méthode pour récupérer toutes les familles en string JSON via l'API pour ensuite parse/découper la string en fonction des champs
    public List<TypeVin> getAllFamily() {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("http://localhost:29200/api/v1/typeVin");
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
    private List<TypeVin> parseJsonArray(String jsonArray) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonArray, new TypeReference<List<TypeVin>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // TODO Gérer les erreurs de parsing ici
            return Collections.emptyList();
        }
    }



    //méthode pour récupérer (read) 1 famille
    public TypeVin getFamilyById(int id) {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("http://localhost:29200/api/v1/typeVin/"+id);
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
        TypeVin apiFamilles = parseJsonString(response.toString());
        return apiFamilles;
    }

    public static TypeVin parseJsonString(String jsonString) {
        try {
            // Utilisation de Jackson ObjectMapper pour mapper la chaîne JSON vers un objet Java
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, TypeVin.class);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO Gérer les erreurs de parsing ici
            return null;
        }
    }

    public void deleteFamily(int id) {
        try {
            URL url = new URL("http://localhost:29200/api/v1/typeVin/"+id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // La suppression a réussi
                System.out.println("Famille supprimée avec succès.");
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

    //méthode pour mettre à jour/modifier une famille --> non fonctionnelle pour l'instant
    public void updateFamily(NewTypeVin updatedFamilles, int id) {
        try {
            URL url = new URL("http://localhost:8765/api/v1/typeVin/"+id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // On définit la méthode de requête sur "PUT"
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // On convertit l'objet Family en JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonFamily = objectMapper.writeValueAsString(updatedFamilles);

            // On envoie les données JSON
            OutputStream outputStream = connection.getOutputStream();
            byte[] input = jsonFamily.getBytes("utf-8");
            outputStream.write(input, 0, input.length);


            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // La mise à jour a réussi
                System.out.println("Famille mise à jour avec succès.");
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


    //Méthode pour créer une famille via la connexion avec l'API --> pas encore fonctionnelle
    public void createFamily(NewTypeVin newFamily) {
        try {
            URL url = new URL("http://localhost:29200/api/v1/typeVin");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // On définit la méthode de requête sur "POST"
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            // On convertit l'objet Family en JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonFamily = objectMapper.writeValueAsString(newFamily);

            // On envoie les données JSON
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            //byte[] input = jsonFamily.getBytes("utf-8");
            //outputStream.write(input, 0, input.length);
            outputStream.write(jsonFamily.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();


            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                // La création a réussi
                System.out.println("Nouvelle famille créée avec succès.");
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
