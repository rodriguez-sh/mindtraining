package sh.rodriguez;

import java.util.Arrays;

/*
Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
Follow-up: what if you can't use division?
 */
public class E230923 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int[] newArray = new int[array.length];

        newArray[0] = product(array[0],1,array,newArray);
        System.out.println(Arrays.toString(newArray));
    }

    public static int product(int cum, int cursor, int[] array, int[] newArray){

        if(cursor == array.length - 1){
            newArray[cursor] = cum;
            return array[cursor];
        }

        int newCum = cum*array[cursor];
        int productAfter = product(newCum,cursor+1,array,newArray);
        newArray[cursor] = cum * productAfter;
        return array[cursor]*productAfter;
    }
}
