package algoexpert;

public class Question30 {

    private int val;
    private int counter;
    public static void main(String[] args) {

    }

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        if (tree == null) {
            return Integer.MIN_VALUE;
        }

        findKthLargestValueInBst(tree.right, k);
        counter++;
        if (counter == k) {
            val = tree.value;
        } else {
            findKthLargestValueInBst(tree.left, k);
        }

        return val;
    }
}
