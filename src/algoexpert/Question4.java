package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class Question4 {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.left.right.left = new BinaryTree(10);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);


        System.out.println(branchSums(tree));
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.

        ArrayList<Integer> list = new ArrayList<>();
        branchSumsHelper(root, 0, list);
        return list;
    }

    public static void branchSumsHelper(BinaryTree root, int sum, List<Integer> list) {
        // Write your code here.
        sum += root.value;

        if (root.left == null && root.right == null) {
            list.add(sum);
        }

        if (root.left != null) {
            branchSumsHelper(root.left, sum, list);
        }

        if (root.right != null) {
            branchSumsHelper(root.right, sum, list);
        }
    }

}
