package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question7 {

    public static void main(String[] args) {
        System.out.println(classPhotos(new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5, 1)),
                new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4, 9))));
    }

    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.

        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        int length = redShirtHeights.size();

        String backRow = redShirtHeights.get(0) < blueShirtHeights.get(0) ? "blue" : "red";

        for (int i = 0; i < length; i++) {
            if (backRow.equals("red")) {
                if (redShirtHeights.get(i) <= blueShirtHeights.get(i)) {
                    return false;
                }
            } else {
                if (blueShirtHeights.get(i) <= redShirtHeights.get(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
