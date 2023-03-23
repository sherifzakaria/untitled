package algoexpert;

import java.util.Arrays;

public class Question32 {

    public static void main(String[] args) {
//        int[] arr = {8, 5, 2, 9, 6, 5, 3};
//        int[] arr = {2, 1};
        int[] arr = {8, -6, 7, 10, 8, -1, 6, 2, 4, -5, 1, 10, 8, -10, -9, -10, 8, 9, -2, 7, -2, 4};
//        int[] arr3 = {5, 2, -8, 3, -10, -6, -1, -2, 9, 1};

        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] quickSort(int[] array) {
        // Write your code here.
        return quickSort(array, 0, array.length - 1);
    }

    public static int[] quickSort(int[] array, int low, int high) {
        // Write your code here.
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);

        }
        return array;
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int leftPointer = low;
        int rightPointer = high - 1;

        while (leftPointer < rightPointer) {
            if (array[leftPointer] > pivot && array[rightPointer] < pivot) {
                swap(array, leftPointer, rightPointer);
            }

            while (array[leftPointer] <= pivot && leftPointer <= rightPointer) {
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && rightPointer > leftPointer) {
                rightPointer--;
            }
        }

        if (array[leftPointer] > pivot) {
            swap(array, high, leftPointer);
        }

        return leftPointer;
    }

    private static void swap(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }

}
