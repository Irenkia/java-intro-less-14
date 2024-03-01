package org.example;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileService {
    private String filePath = "src/main/resources/html.txt";

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

    public static void saveHTMLToFile(String filePath, URL url) {
        if (filePath == null) {
            throw new IllegalArgumentException();
        }
        if (url == null) {
            throw new IllegalArgumentException();
        }
        Path pathToFile = Path.of(filePath);
        try (InputStream in = url.openStream()) {
            Files.copy(in, pathToFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.getMessage();
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
