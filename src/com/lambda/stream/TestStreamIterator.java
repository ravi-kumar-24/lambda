package com.lambda.stream;

import java.util.stream.Stream;

public class TestStreamIterator {
    public static void main(String[] args) {
        //print a number starting from 0 and increament by 1
        //limit number 10
        Stream.iterate(0, n -> n+2).
                limit(10).
                forEach(System.out::println);

        //sum of even number of 100 count
        Stream.iterate(0, n ->(n+1)).
                filter(n -> n%2==0).
                limit(100).
                forEach(System.out::println);

        //classic Fibonacci example.
         Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0]+n[1]}).
                 limit(20).
                  map(n ->n[0]).
                 forEach(System.out::println);

         //Sum all the Fibonacci values.
       long fibonacciSum = Stream.iterate(new int[]{0,1}, n-> new int[]{n[1], n[0]+n[1]}).
                limit(10).
                mapToInt(x ->x[0]).
                 sum();

        System.out.println("Fibonacci 10 sum : "+fibonacciSum);

        //java 9 modified iterate, It supports a predicate (condition) as second argument
        // and the stream.iterate will stop if the predicate is false.
        Stream.iterate(1, n -> n < 20 , n -> n * 2)
                .forEach(x -> System.out.println(x));

    }
}
