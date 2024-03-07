package org.example;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileService {

    public static void saveHTMLToFile(String filePath, URL url) {
        if (filePath == null) {
            throw new IllegalArgumentException("file path can't be null");
        }
        if (url == null) {
            throw new IllegalArgumentException("url can't be null");
        }
        Path pathToFile = Path.of(filePath);
        try (InputStream in = url.openStream()) {
            Files.copy(in, pathToFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error save to file");
            e.getMessage();
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
