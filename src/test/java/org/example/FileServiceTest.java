package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

class FileServiceTest {
    private String filePath = "src/test/resources/html.txt";

    @Test
    void mustCreateFile() {
        //given
        File file = FileService.createFile(filePath);

        //when
        boolean exists = file.exists();

        //then
        Assertions.assertTrue(exists);
    }

    @Test
    void mustSaveHTMLToFile() {
        //given
        URL url;
        try {
            url = new URL("https://futurecollars.com");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        //when
        FileService.saveHTMLToFile(filePath, url);

        //then
        System.out.println("\tPrint text from file : ");
        FileService.printTextFromFile(filePath);
    }
}
