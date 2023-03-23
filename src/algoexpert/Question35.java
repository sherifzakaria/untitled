package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question35 {

    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));
//        MinHeap minHeap = new MinHeap(arr);
//        System.out.println(minHeap.heap);
//
//        minHeap.insert(76);
//        System.out.println(minHeap.heap);
//
//        System.out.println(minHeap.peek());
//
//        System.out.println(minHeap.remove());
//
//        System.out.println(minHeap.peek());
//
//        System.out.println(minHeap.remove());
//
//        System.out.println(minHeap.peek());
//        minHeap.insert(87);
//        System.out.println(minHeap.heap);

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 3, 1));
        MinHeap minHeap = new MinHeap(arr);
        System.out.println(minHeap.heap);
        System.out.println(minHeap.peek());
    }

    static class MinHeap {
        List<Integer> heap;

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            int firstParentIdx = (array.size() - 2) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Write your code here.
            int firstChildIdx = currentIdx * 2 + 1;

            while (firstChildIdx <= endIdx) {
                int smallerElementIdx = firstChildIdx;
                int secondChildIdx = currentIdx * 2 + 2;

                if (secondChildIdx <= endIdx) {
                    smallerElementIdx = heap.get(firstChildIdx) < heap.get(secondChildIdx) ? firstChildIdx : secondChildIdx;
                }

                if (heap.get(currentIdx) > heap.get(smallerElementIdx)) {
                    swap(currentIdx, smallerElementIdx, heap);
                    currentIdx = smallerElementIdx;
                    firstChildIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            // Write your code here.
            if (currentIdx > 0) {
                int parentIdx = (currentIdx - 1) / 2;
                if (heap.get(parentIdx) > heap.get(currentIdx)) {
                    swap(parentIdx, currentIdx, heap);
                    siftUp(parentIdx, heap);
                }
            }
        }

        public int peek() {
            // Write your code here.
            return heap.get(0);
        }

        public int remove() {
            // Write your code here.
            int removedElement = heap.get(0);
            int lastIdx = heap.size() - 1;
            swap(0, lastIdx, heap);
            heap.remove(lastIdx);
            siftDown(0, heap.size() - 1, heap);
            return removedElement;
        }

        public void insert(int value) {
            // Write your code here.
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        private void swap(int firstIdx, int secondIdx, List<Integer> heap) {
            Integer temp = heap.get(firstIdx);
            heap.set(firstIdx, heap.get(secondIdx));
            heap.set(secondIdx, temp);
        }

    }

}
