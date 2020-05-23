package com.lambda.stream;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.generate(() -> { return new Integer(100); });
        stream.forEach(p -> System.out.println(p));

    }

}
