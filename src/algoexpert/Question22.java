package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class Question22 {

    public static void main(String[] args) {
        System.out.println(firstDuplicateValue(new int[]{2, 1, 5, 2, 3, 3, 4}));
    }

    public static int firstDuplicateValue2(int[] array) {
        // Write your code here.
        Map<Integer, Integer> duplicateValuesMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            Integer value = duplicateValuesMap.putIfAbsent(array[i], 1);
            if (value != null) {
                return array[i];
            }
        }
        return -1;
    }

    public static int firstDuplicateValue(int[] array) {
        // Write your code here.


        for (int i = 0; i < array.length; i++) {
            int index = Math.abs(array[i]) - 1;

            if (array[index] < 0) {
                return index + 1;
            } else {
                array[index] *= -1;
            }
        }

        return -1;
    }
}
