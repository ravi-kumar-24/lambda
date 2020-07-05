package com.lambda.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class DuplicateLetterCount {

    public static void main(String[] args) {
        String str = "thisisateststring";
        Map<Integer, Integer> map = new HashMap<>();
        char[] c = str.toCharArray();
        int[] values = {1,2,3,4,4,2,5,4,4,4,2};
        //Arrays.stream(values).forEach(System.out::println);
       // IntStream.range(0, c.length).mapToObj(i -> c[i]).forEach(System.out::println);
        Arrays.stream(values).forEach(num -> map.compute(num, (k,v) -> v == null?1 : v+1));
        System.out.println(map);
        Arrays.stream(values).forEach(word -> map.merge(word, 1, (count, one) -> count + one));
        System.out.println(map);
      //  words.forEach(word -> counter.merge(word, 1, (count, one) -> count + one));
    }

}
