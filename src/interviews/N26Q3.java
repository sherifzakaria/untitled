package interviews;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N26Q3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 4, 3}, 2, 4)));
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 6}, 4, 3)));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, 4, 6)));
        System.out.println(Arrays.toString(solution(new int[]{6, 1}, 1, 1)));
    }

    public static int[] solution(int[] A, int F, int M) {
        // write your code in Java SE 8

        List<Integer> forgottenNumbersList = new ArrayList<>();
        for (int i = 0; i < F; i++) {
            forgottenNumbersList.add(0);
        }
        int numOfRolls = A.length + F;
        long totalNumberWithoutForgotten = 0L;
        for (int j : A) {
            totalNumberWithoutForgotten += j;
        }

        long totalForgotten = ((long) M * numOfRolls) - totalNumberWithoutForgotten;

        long totalNumber = totalForgotten + totalNumberWithoutForgotten;
        if (totalNumber / numOfRolls != M || (F * 6L < totalForgotten) || totalForgotten < 0) {
            return new int[]{0};
        } else {
            long totalRandomNumbers = 0;
            while (totalForgotten != totalRandomNumbers) {
                totalRandomNumbers = 0;
                for (int i = 0; i < F; i++) {
                    int random = (int) ((Math.random() * 6) + 1);
                    totalRandomNumbers += random;
                    forgottenNumbersList.set(i, random);
                }
            }
        }
        int[] result = new int[forgottenNumbersList.size()];
        for (int i = 0; i < forgottenNumbersList.size(); i++) {
            result[i] = forgottenNumbersList.get(i);
        }
        return result;
    }
}
