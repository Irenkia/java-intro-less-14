package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

class FileServiceOtherVersionTest {
    private String filePath = "src/test/resources/newHtml.txt";

    public static File createFile(String filePath) {
        File file = new File(filePath);
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

    @Test
    void mustSaveHTMLToFile() {
        //given
        createFile(filePath);
        URL url;
        try {
            url = new URL("https://futurecollars.com/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        //when
        FileServiceOtherVersion.saveHTMLToFile(filePath, url);

        //then
        System.out.println("\tPrint text from file : ");
        FileServiceOtherVersion.printTextFromFile(filePath);
    }
}
