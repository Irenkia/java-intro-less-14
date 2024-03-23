package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SumOfIntegers {
    public static String getSumFromList(String param) {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest;
        try {
            httpRequest = HttpRequest.newBuilder(new URI("http://localhost:8080/home" + param))
                    .GET().build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpResponse<String> httpResponse;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return httpResponse.body();
    }

}
