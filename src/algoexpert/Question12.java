package algoexpert;

public class Question12 {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}
                , 33));
        System.out.println(binarySearch(new int[]{1, 5, 23, 111}
                , 111));
    }

    public static int binarySearch(int[] array, int target) {
        // Write your code here.

        int mid = (array.length - 1) / 2;
        int start = 0;
        int end = array.length - 1;

        while (end >= 0 && start <= end) {
            if (target < array[mid]) {
                end = mid - 1;
            } else if (target > array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (start + end) / 2;
        }

        return -1;
    }
}
