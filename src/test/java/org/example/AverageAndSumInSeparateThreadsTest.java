package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class AverageAndSumInSeparateThreadsTest {

    @Test
    void mustGetAverageAndSumFromListInSeparateThreads() {
        //given
        List<Integer> numbers = Arrays.asList(3, 5, 7);

        //when
        System.out.println("Average and sum in separate threads :");

        //then
        AverageAndSumInSeparateThreads.getAverageAndSumFromListInSeparateThreads(numbers);
    }

}
