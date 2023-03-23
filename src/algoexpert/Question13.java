package algoexpert;

import java.util.Arrays;

public class Question13 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{10, 5, 9, 10, 12})));
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] sortedArr = new int[3];
        int biggest = 0;
        int mid = 0;
        int smallest = 0;

        biggest = Math.max(Math.max(array[0], array[1]), array[2]);
        smallest = Math.min(Math.min(array[0], array[1]), array[2]);
        if (array[0] == smallest) {
            if (array[1] == biggest) {
                mid = array[2];
            } else {
                mid = array[1];
            }
        } else {
            if (array[0] == biggest) {
                mid = array[1] == smallest ? array[2] : array[1];
            } else {
                mid = array[0];
            }
        }

        for (int i = 3; i < array.length; i++) {
            if (biggest <= array[i]) {
                smallest = mid;
                mid = biggest;
                biggest = array[i];
            } else if (mid <= array[i]) {
                smallest = mid;
                mid = array[i];
            } else if (smallest < array[i]) {
                smallest = array[i];
            }
        }

        sortedArr[0] = smallest;
        sortedArr[1] = mid;
        sortedArr[2] = biggest;

        return sortedArr;
    }
}
