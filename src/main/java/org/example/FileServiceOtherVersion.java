package org.example;

import java.io.File;
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
    private String filePath = "src/main/resources/newHtml.txt";

    public static File createFile(String fileName) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File has been created.");
            }
        } catch (IOException e) {
            System.out.println("File already exists.");
            e.printStackTrace();
        }
        return file;
    }

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
            throw new IllegalArgumentException();
        }
        if (url == null) {
            throw new IllegalArgumentException();
        }

        String htmlString = null;
        try {
            htmlString = connect(filePath, url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(htmlString);
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void printTextFromFile(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException();
        }
        try {
            String text = Files.readString(Path.of(filePath));
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
