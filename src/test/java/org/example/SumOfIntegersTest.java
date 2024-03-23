package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumOfIntegersTest {

    @Test
    void mustGetSumFromList() {
        //given
        String param = "?list=3&list=5&list=7";
        String excepted = "15";

        //when
        String result = SumOfIntegers.getSumFromList(param);

        //then
        Assertions.assertEquals(excepted, result);
    }
}
