package algoexpert;

import java.util.Arrays;

public class Question25 {

    public static void main(String[] args) {
        System.out.println(nonConstructibleChange(new int[]{1, 2, 5}));
        System.out.println(nonConstructibleChange(new int[]{5, 7, 1, 1, 2, 3, 22}));
    }

    public static int nonConstructibleChange(int[] coins) {
        // Write your code here.

        Arrays.sort(coins);

        int total = 0;
        for (int i = 0; i < coins.length - 1; i++) {
            total += coins[i];
            if (total + 1 < coins[i + 1]) {
                return total + 1;
            }
        }

        return coins.length < 1 ? 1 : coins[0] > 1 ? 1 : total + coins[coins.length - 1] + 1;
    }


}
