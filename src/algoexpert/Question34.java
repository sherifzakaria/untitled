package algoexpert;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Question34 {

    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    public static int[] mergeSort(int[] array) {
        // Write your code here.
        int[] aux = new int[array.length];
        mergeSort(array, aux, 0, array.length - 1);
        return array;
    }

    public static void mergeSort(int[] array, int[] aux, int low, int high) {
        // Write your code here.
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, aux, low, mid);
            mergeSort(array, aux, mid + 1, high);
            merge(array, aux, low, mid, high);
        }
    }

    private static void merge(int[] array, int[] aux, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = array[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (aux[i] <= aux[j]) {
                array[k] = aux[i];
                i++;
            } else {
                array[k] = aux[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            array[k++] = aux[i++];
        }
        while (j <= high) {
            array[k++] = aux[j++];
        }
    }
}
