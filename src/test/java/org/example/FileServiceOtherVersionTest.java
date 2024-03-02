package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

class FileServiceOtherVersionTest {
    private String filePath = "src/test/resources/newHtml.txt";

    @Test
    void mustCreateFile() {
        //given
        File file = FileServiceOtherVersion.createFile(filePath);

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
