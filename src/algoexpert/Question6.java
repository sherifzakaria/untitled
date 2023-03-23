package algoexpert;

import java.util.Arrays;

public class Question6 {
    public static void main(String[] args) {
        System.out.println(minimumWaitingTime(new int[] {5, 1, 4}));
        System.out.println(minimumWaitingTime(new int[] {3, 2, 1, 2, 6}));
    }

//    public static int minimumWaitingTime(int[] queries) {
//        // Write your code here.
//        Arrays.sort(queries);
//        int sum = 0;
//
//        for (int i = 1; i < queries.length; i++) {
//            int waitingTime = 0;
//            for (int j = 0; j < i; j++) {
//                waitingTime += queries[j];
//            }
//            sum += waitingTime;
//        }
//        return sum;
//    }

    public static int minimumWaitingTime(int[] queries) {
        // Write your code here.
        Arrays.sort(queries);
        int totalWaitingTime = 0;

        for (int i = 0; i < queries.length; i++) {
            int time = queries[i] * (queries.length - 1 - i);
            totalWaitingTime += time;
        }
        return totalWaitingTime;
    }
}
