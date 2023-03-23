package algoexpert;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question37 {
    public static void main(String[] args) {
        ContinuousMedianHandler continuousMedianHandler = new ContinuousMedianHandler();
        continuousMedianHandler.insert(5);
        continuousMedianHandler.insert(10);
        System.out.println(continuousMedianHandler.getMedian());
        continuousMedianHandler.insert(100);
        System.out.println(continuousMedianHandler.getMedian());
    }

    static class ContinuousMedianHandler {

        double median = 0;
        private final PriorityQueue<Integer> smallHeap = new PriorityQueue<>(Comparator.reverseOrder());
        private final PriorityQueue<Integer> largeHeap = new PriorityQueue<>();

        public void insert(int number) {
            // Write your code here.

            if (!largeHeap.isEmpty() && number > largeHeap.peek()) {
                largeHeap.add(number);
            } else {
                smallHeap.add(number);
            }

            if (smallHeap.size() > largeHeap.size() + 1) {
                int maxNum = smallHeap.remove();
                largeHeap.add(maxNum);
            }

            if (largeHeap.size() > smallHeap.size() + 1) {
                int minNum = largeHeap.remove();
                smallHeap.add(minNum);
            }

            if (smallHeap.size() > largeHeap.size()) {
                median = smallHeap.peek();
            } else if (largeHeap.size() > smallHeap.size()) {
                median = largeHeap.peek();
            } else {
                median = (smallHeap.peek() + largeHeap.peek()) / 2.0;
            }
        }

        public double getMedian() {
            return median;
        }
    }
}
