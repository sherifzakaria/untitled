package algoexpert;

import java.util.Arrays;

public class Question1 {

    public static void main(String[] args) {
        int[] arrayOne = new int[]{-1, 5, 10, 20, 28, 3}; // -1, 3, 5, 10, 20, 28
        int[] arrayTwo = new int[]{26, 134, 135, 15, 17}; // 15, 17, 26, 134, 135
//        System.out.println(Arrays.toString(smallestDifference(arrayOne, arrayTwo)));
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = String.valueOf("abc");

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str3);
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        int[] pair = new int[]{0, 0};

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int pointerOne = 0;
        int pointerTwo = 0;

        int closestToZero = Math.abs(arrayOne[pointerOne] - arrayTwo[pointerTwo]);
        int closestPairOne = 0;
        int closestPairTwo = 0;

        while (pointerOne < arrayOne.length && pointerTwo < arrayTwo.length) {
            int absDiff = Math.abs(arrayOne[pointerOne] - arrayTwo[pointerTwo]);
            if (absDiff < closestToZero) {
                closestToZero = absDiff;
                closestPairOne = pointerOne;
                closestPairTwo = pointerTwo;
            }
            if (absDiff == 0) {
                break;
            } else if (arrayOne[pointerOne] < arrayTwo[pointerTwo]) {
                if (pointerTwo == arrayTwo.length) {
                    break;
                }
                pointerOne++;
            } else {
                if (pointerOne == arrayOne.length) {
                    break;
                }
                pointerTwo++;
            }
        }

        pair[0] = arrayOne[closestPairOne];
        pair[1] = arrayTwo[closestPairTwo];
        return pair;
    }
}
