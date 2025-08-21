package com.srmortenreb.conversor.conversordemonedas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ApiService {

    private static final String API_KEY = "T0c309f0494cd7fc42b0b60e8";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/0c309f0494cd7fc42b0b60e8/latest/USD";

    // Para demo rápida, retorna un JSON simulado
    public static JsonObject obtenerJson() throws IOException, InterruptedException {
        // Si quieres probar la API real, descomenta estas líneas
        /*
        String url = BASE_URL + API_KEY + "/latest/USD";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Respuesta de la API: " + response.body());
        return JsonParser.parseString(response.body()).getAsJsonObject();
        */

        // JSON simulado para demo
        String demo = "{ \"conversion_rates\": { \"ARS\": 270.5, \"BRL\": 5.2, \"COP\": 4800 } }";
        return JsonParser.parseString(demo).getAsJsonObject();
    }

    public static double obtenerTasa(String moneda) throws IOException, InterruptedException {
        JsonObject json = obtenerJson();
        JsonObject conversionRates = json.getAsJsonObject("conversion_rates");
        return conversionRates.get(moneda).getAsDouble();
    }
}
