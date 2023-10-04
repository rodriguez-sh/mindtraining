package sh.rodriguez;

import java.util.HashSet;

/*
This problem was asked by Airbnb.

Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?
 */
public class E231004 {

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, -6, 2, 5};

        for(int j = array.length-3; j >= 0; j--){
            if(j == array.length-3){
                if(array[j] + array[j+2] >= array[j]){
                    array[j] = array[j] + array[j+2];
                }else{
                    array[j] = Math.max(array[j+1],array[j+2]);
                }
            }else {
                int cand1 = array[j] + array[j+2] > array[j+2] ? array[j] + array[j+2] : array[j+2];
                int cand2 = array[j] + array[j+3] > array[j+3] ? array[j] + array[j+3] : array[j+3];
                int winner = Math.max(cand1,cand2);
                if(winner > array[j]){
                    array[j] = winner;
                }else{
                    array[j] = Math.max(array[j+1],array[j+2]);
                }
            }
        }

        int winner = Math.max(array[0],array[1]);

        System.out.println("Best result: "+winner);
    }
}
