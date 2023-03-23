package algoexpert;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Question3 {
    public static void main(String[] args) {
        System.out.println(nonConstructibleChange(new int[]{1, 2, 5}));
    }

    public static int nonConstructibleChange(int[] coins) {
        // Write your code here.
        if (coins.length < 1) {
            return 1;
        }

        Set<int[]> numSet = new HashSet<>(Collections.singletonList(coins));
        Arrays.sort(coins);

        for (int i = 0; i < coins.length - 1; i++) {
            int sum = coins[i] + coins[i + 1] + 1;
            if (!numSet.contains(sum)) {
                return sum;
            }
        }

        return coins[coins.length - 2] + coins[coins.length - 1];
    }
}
