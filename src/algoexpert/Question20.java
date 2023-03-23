package algoexpert;

public class Question20 {

    public static void main(String[] args) {
        System.out.println(longestPeak(new int[]{1, 2, 5, 3, 1, 5}));
        System.out.println(longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}));
    }

    public static int longestPeak(int[] array) {
        // Write your code here.

        int peakLength = 0;
        int up = 0;
        int down = 0;

        for (int i = 0; i < array.length - 1; i++) {

            if (down > 0) {
                if (array[i] < array[i + 1]) {
                    down = 0;
                    up = 1;
                } else if (array[i] > array[i + 1]) {
                    down++;
                } else {
                    down = 0;
                    up = 0;
                }
            } else {
                if (array[i] < array[i + 1]) {
                    up++;
                } else if (array[i] > array[i + 1] && up > 0) {
                    down++;
                } else {
                    down = 0;
                    up = 0;
                }
            }

            if (down > 0 && up > 0) {
                peakLength = Math.max(down + up, peakLength);
            }
        }

            return peakLength > 0 ? peakLength + 1 : 0;
    }

}
