package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceOtherVersion {

    public static String connect(String filePath, URL url) throws Exception {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest =
                HttpRequest.newBuilder(new URI(url + filePath))
                        .GET()
                        .build();
        HttpResponse<String> httpResponse = httpClient
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();
    }

    public static void saveHTMLToFile(String filePath, URL url) {
        if (filePath == null) {
            throw new IllegalArgumentException("file path can't be null");
        }
        if (url == null) {
            throw new IllegalArgumentException("url can't be null");
        }

        String htmlString = null;
        try {
            htmlString = connect(filePath, url);
        } catch (Exception e) {
            throw new RuntimeException("Error connection");
        }

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(htmlString);
            fileWriter.close();
        } catch (IOException exception) {
            System.out.println("Error save to file");
            exception.printStackTrace();
        }
    }

    public static void printTextFromFile(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("file path can't be null");
        }
        try {
            String text = Files.readString(Path.of(filePath));
            System.out.println(text);
        } catch (Exception e) {
            System.out.println("Error reading from file");
            e.printStackTrace();
        }
    }
}
