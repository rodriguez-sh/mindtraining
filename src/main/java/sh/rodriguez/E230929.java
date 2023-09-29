package sh.rodriguez;

import java.util.Arrays;
import java.util.HashSet;

/*
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array.
The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 */
public class E230929 {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6};
        HashSet<Integer> elements = new HashSet<>();
        int firstMissingPositive = 1;

        for(int i = 0; i < array.length; i++){
            if(array[i] < 0) continue;

            if(firstMissingPositive < array[i]){
                elements.add(array[i]);
            }else{
                do{
                    firstMissingPositive++;
                }while (elements.contains(firstMissingPositive));
            }

        }

        System.out.println("First Missing Positive: "+firstMissingPositive);
    }
}
