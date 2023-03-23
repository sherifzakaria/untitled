package algoexpert;

import java.util.Arrays;

public class Question36 {

    private static int lastHeapIdx = 0;

    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(heapSort(input)));
    }

    public static int[] heapSort(int[] array) {
        lastHeapIdx = array.length - 1;
        buildHeap(array);
        for (int i = 0; i < array.length; i++) {
            remove(array);
        }
        return array;
    }

    private static void buildHeap(int[] array) {
        // Write your code here.
        int firstParentIdx = (array.length - 2) / 2;
        for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
            siftDown(currentIdx, array.length - 1, array);
        }
    }

    private static void siftDown(int currentIdx, int endIdx, int[] heap) {
        // Write your code here.
        int firstChildIdx = currentIdx * 2 + 1;

        while (firstChildIdx <= endIdx) {
            int swapElementIdx = firstChildIdx;
            int secondChildIdx = currentIdx * 2 + 2;

            if (secondChildIdx <= endIdx) {
                swapElementIdx = heap[firstChildIdx] > heap[secondChildIdx] ? firstChildIdx : secondChildIdx;
            }

            if (heap[currentIdx] < heap[swapElementIdx]) {
                swap(currentIdx, swapElementIdx, heap);
                currentIdx = swapElementIdx;
                firstChildIdx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    private static void remove(int[] array) {
        // Write your code here.
        swap(0, lastHeapIdx, array);
        siftDown(0, --lastHeapIdx, array);
    }

    private static void swap(int firstIdx, int secondIdx, int[] heap) {
        int temp = heap[firstIdx];
        heap[firstIdx] = heap[secondIdx];
        heap[secondIdx] = temp;
    }
}
