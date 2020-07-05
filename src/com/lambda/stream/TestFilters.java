package com.lambda.stream;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestFilters {
    public static void main(String[] args) {
        List<String> memberNames = LambdaUtils.getNames();
        Predicate<String> stringPredicate = s -> s.startsWith("A");
        memberNames.stream().filter(stringPredicate)
                .forEachOrdered(System.out::println);

        memberNames.stream().filter((s) -> s.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //Sorted the name and map to upper case
        memberNames.stream().
                sorted(Comparator.reverseOrder()).
                map(String::toUpperCase).
                forEach(System.out::println);

        memberNames.stream().
                sorted().
                reduce((s1, s2) -> s1 +", "+s2).
                ifPresent(System.out::println);
        memberNames.stream().
                reduce((s1,s2) -> s1.length() >= s2.length()?s1:s2).ifPresent(System.out::println);

        String s = memberNames.stream().
                sorted().
                collect(Collectors.joining(", "));
        System.out.println(s);

        // Creating list of integers
        List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);

        int x=9;
        // Finding sum of all elements
        int sum = array.stream().reduce(x,
                (element1, element2) -> element1 + element2);
        // Displaying sum of all elements
        System.out.println("The sum of all elements is " + sum);

        // To get the product of all elements
        // in given range excluding the
        // rightmost element
        int product = IntStream.range(2, 8)
                .reduce((num1, num2) -> num1 * num2)
                .orElse(-1);

        // Displaying the product
        System.out.println("The product is : " + product);




    }
}
