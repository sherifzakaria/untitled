package algoexpert;

public class Question39 {

    public static void main(String[] args) {

    }

    public static void invertBinaryTree(BinaryTree tree) {
        // Write your code here.
        if (tree == null) {
            return;
        }
        swap(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    private static void swap(BinaryTree tree) {
        BinaryTree leftChild = tree.left;
        tree.left = tree.right;
        tree.right = leftChild;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
