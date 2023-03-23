package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question29 {

    public static void main(String[] args) {
        BST tree = minHeightBst(Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22));
        List<Integer> arr = new ArrayList<>();
        inOrderTraverse(tree, arr);
        System.out.println(arr);
    }

    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        int start = 0;
        int end = array.size() - 1;
        int mid = (start + end) / 2;
        BST tree = new BST(array.get(mid));
        minHeightBstHelper(tree, array, start, mid - 1);
        minHeightBstHelper(tree, array, mid + 1, end);
        return tree;
    }

    private static void minHeightBstHelper(BST tree, List<Integer> array, int start, int end) {
        int mid = (start + end) / 2;

        if (start > end) {
            return;
        }

        if (array.get(mid) < tree.value) {
            tree.left = new BST(array.get(mid));
            int endLeft = mid - 1;
            minHeightBstHelper(tree.left, array, start, endLeft);
            int startRight = mid + 1;
            minHeightBstHelper(tree.left, array, startRight, end);
        } else {
            tree.right = new BST(array.get(mid));
            int startRight = mid + 1;
            minHeightBstHelper(tree.right, array, startRight, end);
            int endLeft = mid - 1;
            minHeightBstHelper(tree.right, array, start, endLeft);
        }
    }

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if (tree == null) {
            return Collections.emptyList();
        }
        inOrderTraverse(tree.left, array);
        array.add(tree.value);
        inOrderTraverse(tree.right, array);
        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
