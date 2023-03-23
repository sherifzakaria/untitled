package algoexpert;

import java.util.Arrays;

public class Question21 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfProducts(new int[]{5, 1, 4, 2})));
        System.out.println(Arrays.toString(arrayOfProducts(new int[]{0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(arrayOfProducts(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9})));
    }

    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int[] productArr = new int[array.length];
        int totalMultiplication = 1;
        int zeroCount = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                totalMultiplication *= array[i];
            } else {
                zeroCount++;
                if (zeroCount > 1) {
                    return new int[array.length];
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                productArr[i] = totalMultiplication;
            } else {
                productArr[i] = zeroCount != 1 ? totalMultiplication / array[i] : 0;
            }
        }

        return productArr;
    }
}
