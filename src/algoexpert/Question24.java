package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question24 {

    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(mergeOverlappingIntervals(new int[][]{
//                {1, 2},
//                {3, 5},
//                {4, 7},
//                {6, 8},
//                {9, 10}
//        })));

//        System.out.println(Arrays.deepToString(mergeOverlappingIntervals(new int[][]{
//                {1, 22},
//                {-20, 30}
//        })));

        System.out.println(Arrays.deepToString(mergeOverlappingIntervals(new int[][]{
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}
        })));
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        List<int[]> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < intervals.length - 1; i++) {

            int first = intervals[i][0];
            int second = intervals[i][1];
            int third = intervals[i + 1][0];
            int fourth = intervals[i + 1][1];

            if (first < third && second < third) {
                mergedIntervals.add(intervals[i]);
                continue;
            }
            if (third >= first && third <= second) {
                intervals[i + 1][0] = first;
            }

            intervals[i + 1][1] = Math.max(second, fourth);
        }

        mergedIntervals.add(intervals[intervals.length - 1]);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
