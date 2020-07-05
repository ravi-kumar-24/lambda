package com.test;

public class Test {

      public static void main(String[] args) {
        int input = 15;
        String output = Integer.toString(input, 2);
        System.out.println(output);

        String binaryString = "1110";
        int decimal = Integer.parseInt(binaryString, 2);
        System.out.println(decimal);
    }
}
