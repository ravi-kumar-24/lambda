package com.test;

import java.util.*;

public class SliceLogestNumber {

    private static int calculateLargestSlice(int[] array) {

        Map<Integer, Integer> temporaryMap = new HashMap<>();

        int result = 0;
        int startIndex = 0;
        int uniqueItemCount = 0;

        while (startIndex < array.length) { // loop over the entire input sequence
            temporaryMap.put(array[startIndex], startIndex);
            uniqueItemCount++;

            for (int j = startIndex + 1; j < array.length; j++) {
                if (temporaryMap.get(array[j]) == null) {
                    if (uniqueItemCount != 2) {
                        temporaryMap.put(array[j], j);

                        uniqueItemCount++;
                        if (j == array.length - 1) {
                            result = Math.max(result, j - startIndex + 1);
                            startIndex = array.length;
                            break;
                        }
                    } else {
                        result = Math.max(result, j - startIndex);
                        int item = array[j-1];
                        int firstFoundIndex = 0;
                        for( int k=j-1; k>=0; k-- )
                        {
                            if( array[k] != item )
                            {
                                firstFoundIndex = k+1;
                                break;
                            }
                        }
                        startIndex = firstFoundIndex;
                        temporaryMap.clear();
                        uniqueItemCount = 0;
                        break;
                    }
                } else if (temporaryMap.get(array[j]) != null) {
                    if (j == array.length - 1) {
                        result = Math.max(result, j - startIndex + 1);
                        startIndex = array.length;
                        break;
                    }
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[] arr ={1,4,4,5,4,5,7};
        System.out.println(calculateLargestSlice(arr));
    }
}
