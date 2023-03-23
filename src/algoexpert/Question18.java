package algoexpert;

public class Question18 {
    public static void main(String[] args) {

        System.out.println(isMonotonic(new int[]{1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11}));
    }

    public static boolean isMonotonic(int[] array) {

        boolean nonDecreasing = true;
        boolean nonIncreasing = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                nonDecreasing = false;
            }

            if (array[i] > array[i + 1]) {
                nonIncreasing = false;
            }
        }
        return nonIncreasing || nonDecreasing;
    }

    public static boolean isMonotoni2(int[] array) {

        if (array.length <= 1) {
            return true;
        }
        boolean increasing = array[0] <= array[1];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                increasing = array[i] < array[i + 1];
                break;
            }
        }

        for (int i = 1; i < array.length - 1; i++) {
            if (increasing) {
                if (array[i] > array[i + 1]) {
                    return false;
                }
            } else {
                if (array[i] < array[i + 1]) {
                    return false;
                }
            }

        }
        return true;
    }
}
