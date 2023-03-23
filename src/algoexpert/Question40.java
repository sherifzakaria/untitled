package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question40 {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(List.of(10, 4, 2, 1, 3, 5, 6, 9, 7, 17, 19, 18));
        Question40 problem = new Question40();
        problem.reconstructBst(arr);
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        BST root = new BST(preOrderTraversalValues.get(0));
        BST currentNode = root;
        BST parentNode = null;

        for (int i = 1; i < preOrderTraversalValues.size(); i++) {

            if (preOrderTraversalValues.get(i) < root.value) {
//                leftSubtree
                if (currentNode.value > root.value) {
                    currentNode = root;
                }
                if (preOrderTraversalValues.get(i) < preOrderTraversalValues.get(i - 1)) {
                    currentNode.left = new BST(preOrderTraversalValues.get(i));
                    currentNode = currentNode.left;
                } else {
                    currentNode = root.left;
                    parentNode = root.left;
                    while (currentNode != null) {
                        if (preOrderTraversalValues.get(i) < currentNode.value) {
                            parentNode = currentNode;
                            currentNode = currentNode.left;
                        } else {
                            parentNode = currentNode;
                            currentNode = currentNode.right;
                        }
                    }
                    if (parentNode.value <= preOrderTraversalValues.get(i)) {
                        parentNode.right = new BST(preOrderTraversalValues.get(i));
                        currentNode = parentNode.right;
                    } else {
                        parentNode.left = new BST(preOrderTraversalValues.get(i));
                        currentNode = parentNode.left;
                    }
                }
            } else {
//                rightSubtree
                if (currentNode.value < root.value) {
                    currentNode = root;
                }
                if (preOrderTraversalValues.get(i) >= preOrderTraversalValues.get(i - 1)) {
                    currentNode.right = new BST(preOrderTraversalValues.get(i));
                    currentNode = currentNode.right;
                } else {
                    currentNode = root.right;
                    parentNode = root.right;
                    while (currentNode != null) {
                        if (preOrderTraversalValues.get(i) < currentNode.value) {
                            parentNode = currentNode;
                            currentNode = currentNode.left;
                        } else {
                            parentNode = currentNode;
                            currentNode = currentNode.right;
                        }
                    }
                    if (parentNode.value <= preOrderTraversalValues.get(i)) {
                        parentNode.right = new BST(preOrderTraversalValues.get(i));
                        currentNode = parentNode.right;
                    } else {
                        parentNode.left = new BST(preOrderTraversalValues.get(i));
                        currentNode = parentNode.left;
                    }
                }
            }
        }
        return root;
    }
}
