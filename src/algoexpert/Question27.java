package algoexpert;

public class Question27 {

    public static void main(String[] args) {

        BST tree = new BST(10);
        tree.right = new BST(15);
        tree.right.right = new BST(22);
        tree.right.left = new BST(13);
        tree.right.left.right = new BST(14);
        tree.left = new BST(5);
        tree.left.right = new BST(5);
        tree.left.left = new BST(2);
        tree.left.left.left = new BST(1);
//        tree.left.left.left.left = new BST(-5);
//        tree.left.left.left.left.right = new BST(-5);
//        tree.left.left.left.left.right.right = new BST(-2);
//        tree.left.left.left.left.right.right.right = new BST(-1);
//        tree.left.left.left.left.left = new BST(-15);
//        tree.left.left.left.left.left.left = new BST(-22);

//        BST tree = new BST(10);
//        tree.right = new BST(15);
//        tree.left = new BST(5);
//        tree.left.right = new BST(10);

//        BST tree = new BST(10);
//        tree.right = new BST(15);
//        tree.right.right = new BST(22);
//        tree.right.left = new BST(13);
//        tree.right.left.right = new BST(16);
//        tree.left = new BST(5);
//        tree.left.right = new BST(5);
//        tree.left.left = new BST(2);
//        tree.left.left.left = new BST(1);
        //tree.left.left.left.right = new BST(1);
        //tree.left.right.right = new BST(11);
        System.out.println(validateBst(tree));
    }

    public static boolean validateBst(BST tree) {
        // Write your code here.
        int minimumValue = Integer.MIN_VALUE;
        int maximumValue = Integer.MAX_VALUE;
        return validateBstHelper(tree, minimumValue, maximumValue);
    }

    private static boolean validateBstHelper(BST tree, int minimumValue, int maximumValue) {
        if (tree == null) {
            return true;
        }
        if (tree.value < minimumValue || tree.value >= maximumValue) {
            return false;
        }

        return validateBstHelper(tree.left, minimumValue, tree.value) && validateBstHelper(tree.right, tree.value, maximumValue);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
