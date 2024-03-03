package org.example;

import java.util.List;
import java.util.OptionalDouble;

public class AverageAndSumInSeparateThreads {
    public static void getAverageAndSumFromListInSeparateThreads(List<Integer> numbers) {
        Runnable firstForAverage = () -> {
            numbers.stream().forEach(x -> System.out.println("Thread ID: " + Thread.currentThread().getId() + " number: " + x));
            OptionalDouble average = numbers
                    .stream()
                    .mapToDouble(a -> a)
                    .average();
            System.out.println("Thread ID: " + Thread.currentThread().getId() + " Average: " + (average.isPresent() ? average.getAsDouble() : 0));
        };

        Runnable secondForSum = () -> {
            numbers.stream().forEach(x -> System.out.println("Thread ID: " + Thread.currentThread().getId() + " number: " + x));
            int sum = numbers
                    .stream()
                    .mapToInt(n -> n)
                    .sum();
            System.out.println("Thread ID: " + Thread.currentThread().getId() + " Sum: " + sum);
        };

        Thread firstThread = new Thread(firstForAverage);
        Thread secondThread = new Thread(secondForSum);

        firstThread.start();
        secondThread.start();
    }

}
