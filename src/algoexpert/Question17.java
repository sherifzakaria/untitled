package algoexpert;

import java.util.Arrays;
import java.util.List;

public class Question17 {

    public static void main(String[] args) {
        System.out.println(moveElementToEnd(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2));
    }

    public static List<Integer> moveElementToEnd2(List<Integer> array, int toMove) {
        // Write your code here.
        int endIndex = array.size() - 1;
        for (int i = 0; i < endIndex; i++) {
            if (array.get(endIndex) == toMove) {
                endIndex--;
                i--;
                continue;
            }
            if (array.get(i) == toMove) {
                int temp = array.get(endIndex);
                array.set(endIndex, toMove);
                array.set(i, temp);
                endIndex--;
            }
        }
        return array;
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int endIndex = array.size() - 1;
        for (int i = 0; i < endIndex; i++) {
            while (i < endIndex && array.get(endIndex) == toMove) {
                endIndex--;
            }
            if (array.get(i) == toMove) {
                int temp = array.get(endIndex);
                array.set(endIndex, toMove);
                array.set(i, temp);
                endIndex--;
            }
        }
        return array;
    }
}
