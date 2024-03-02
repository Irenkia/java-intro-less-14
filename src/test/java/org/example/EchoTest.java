package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EchoTest {

    @Test
    void mustGetTextFromHttpClient() {
        //given
        String text = "?text=hello%20world!";
        String excepted = "HELLO WORLD!";

        //when
        String result = Echo.getTextFromHttpClient(text);

        //then
        Assertions.assertEquals(excepted, result);
    }
}
