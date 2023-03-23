package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question38 {

    public static void main(String[] args) {
        int[][] times = new int[][]{{0, 2}, {1, 4}, {4, 6}, {0, 4}, {7, 8}, {9, 11}, {3, 10}};
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        for (int[] time : times) {
            input.add(new ArrayList<>(Arrays.asList(time[0], time[1])));
        }
        System.out.println(laptopRentals(input));
    }

    public static int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        // Write your code here.
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();

        if (!times.isEmpty()) {
            times.sort(Comparator.comparingInt(timeInterval -> timeInterval.get(0)));

            endTimeQueue.add(times.get(0).get(1));
            for (int i = 1; i < times.size(); i++) {
                if (endTimeQueue.peek() <= times.get(i).get(0)) {
                    endTimeQueue.remove();
                }
                endTimeQueue.add(times.get(i).get(1));
            }
        }
        return endTimeQueue.size();
    }
}
