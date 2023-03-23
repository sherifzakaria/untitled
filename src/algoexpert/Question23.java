package algoexpert;

import java.util.*;

public class Question23 {

    public static void main(String[] args) {
//        List<Integer[]> result = threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, 0, -8, -1, 6}, 0);
        // -8, -6, -1, 0, 1, 2, 3, 5, 6, 12

        List<Integer[]> result = threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, 0, -8, -1, 6, -5}, 0);
        // -8, -6, -5, -1, 0, 1, 2, 3, 5, 6, 12
        for (Integer[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();

        for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {
            int secondIndex = firstIndex + 1;
            int thirdIndex = array.length - 1;
            int rightSum = targetSum - array[firstIndex];
            while (secondIndex < thirdIndex) {
                int rightNum = array[secondIndex] + array[thirdIndex];
                if (rightSum == rightNum) {
                    Integer[] arr = new Integer[]{array[firstIndex], array[secondIndex], array[thirdIndex]};
                    Arrays.sort(arr);
                    result.add(arr);
                    secondIndex++;
                    thirdIndex--;
                } else if (rightSum > rightNum) {
                    secondIndex++;
                } else {
                    thirdIndex--;
                }
            }
        }

        return result;
    }
}
