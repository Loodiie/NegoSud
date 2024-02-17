package grp.cesi.negosud_javafx;

import com.fasterxml.jackson.core.JsonProcessingException;
import grp.cesi.negosud_javafx.model.adresses.Adresses;
import grp.cesi.negosud_javafx.model.adresses.NewAdresses;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;

class call {
    public static void main(String[] args) throws JsonProcessingException {

        String rep = get("familles",1);
    }
    public static String getAll(String table){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:29200/api/v1/" + table))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());
        return response.body();
    }
    public static String get(String table, int id){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:29200/api/v1/" + table + "/" + id))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());
        return response.body();
    }
    public static String delete(String table, int id){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:29200/api/v1/" + table + "/" + id))
                .method("DELETE", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());
        return response.body();
    }
    public static String create(String table, String body){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:29200/api/v1/" + table))
                .setHeader("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());
        return response.body();
    }
    public static String update(String table, int id, String body){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:29200/api/v1/" + table + "/" + id))
                .setHeader("Content-Type","application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());
        return response.body();
    }
}
