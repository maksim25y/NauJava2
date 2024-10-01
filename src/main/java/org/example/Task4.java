package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Task4 {
    private static final String URL = "https://httpbin.org/get";
    public void start() throws IOException, InterruptedException {
        try (HttpClient client = HttpClient.newHttpClient())
        {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            try
            {
                ObjectMapper objectMapper = new ObjectMapper();
                Map responseMap = objectMapper.readValue(responseBody, Map.class);

                String host = ((Map<String, String>) responseMap.get("headers")).get("Host");
                System.out.println("Host: " + host);
            }
            catch (Exception e)
            {
                System.out.println("Ошибка получения данных из JSON");
            }
        }
    }
}
