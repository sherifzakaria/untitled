package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class Question19 {
    public static void main(String[] args) {

        System.out.println(spiralTraverse(new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        }));

        System.out.println(spiralTraverse(new int[][]{
                {1, 2, 3},
                {12, 13, 4},
                {11, 14, 5},
                {10, 15, 6},
                {9, 8, 7}
        }));
    }

    public static List<Integer> spiralTraverse2(int[][] array) {
        // Write your code here.
        int yUpperLimit = array.length - 1;
        int xUpperLimit = array[0].length - 1;
        int yLowerLimit = 1;
        int xLowerLimit = 0;

        List<Integer> spiralList = new ArrayList<>();

        boolean rightDown = true;
        int xPointer = 0;
        int yPointer = 0;

        while (spiralList.size() < (array.length * array[0].length)) {

            if (rightDown) {
                for (; xPointer <= xUpperLimit; xPointer++) {
                    spiralList.add(array[yPointer][xPointer]);
                }
                xPointer--;
                yPointer++;

                for (; yPointer <= yUpperLimit; yPointer++) {
                    spiralList.add(array[yPointer][xPointer]);
                }
                yPointer--;
                xPointer--;
                xUpperLimit--;
                yUpperLimit--;

            } else {
                for (; xPointer >= xLowerLimit; xPointer--) {
                    spiralList.add(array[yPointer][xPointer]);
                }
                xPointer++;
                yPointer--;
                for (; yPointer >= yLowerLimit; yPointer--) {
                    spiralList.add(array[yPointer][xPointer]);
                }
                yPointer++;
                xPointer++;
                xLowerLimit++;
                yLowerLimit++;
            }

            rightDown = !rightDown;
        }

        return spiralList;
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> spiralList = new ArrayList<>();

        int startCol = 0;
        int endCol = array[0].length - 1;
        int startRow = 0;
        int endRow = array.length - 1;

        while (startCol <= endCol && startRow <= endRow) {

            for (int col = startCol; col <= endCol; col++) {
                spiralList.add(array[startRow][col]);
            }

            for (int row = startRow + 1; row <= endRow; row++) {
                spiralList.add(array[row][endCol]);
            }

            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow) {
                    break;
                }
                spiralList.add(array[endRow][col]);
            }

            for (int row = endRow - 1; row > startRow; row--) {
                if (startCol == endCol) {
                    break;
                }
                spiralList.add(array[row][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return spiralList;
    }
}
