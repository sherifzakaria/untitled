package algoexpert;

import java.util.Arrays;

public class Question8 {

    public static void main(String[] args) {
        System.out.println(tandemBicycle(
                new int[]{5, 5, 3, 9, 2},
                new int[]{3, 6, 7, 2, 1},
                true));
    }

    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        int totalTime = 0;
        int length = redShirtSpeeds.length;

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if (fastest) {
            for (int i = 0; i < length/2; i++) {
                int small = blueShirtSpeeds[i];
                int big = blueShirtSpeeds[length - 1 - i];
                blueShirtSpeeds[i] = big;
                blueShirtSpeeds[length - 1 - i] = small;
            }
        }

        for (int i = 0; i < length; i++) {
            if (fastest) {
                totalTime += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            } else {
                totalTime += Math.min(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        }
        return totalTime;
    }
}
