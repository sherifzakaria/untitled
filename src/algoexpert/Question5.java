package algoexpert;

public class Question5 {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(1);
//        tree.left = new BinaryTree(2);
//        tree.left.left = new BinaryTree(3);
//        tree.left.left.left = new BinaryTree(4);
//        tree.left.left.left.left = new BinaryTree(5);
//        tree.left.left.left.left.left = new BinaryTree(6);
//        tree.left.left.left.left.left.right = new BinaryTree(7);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);
        
        System.out.println(nodeDepths(tree));
    }

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
//        return nodeDepthsSum(root, 0, 0);
        return nodeDepthsHelper(root, 0);
    }

    private static int nodeDepthsSum(BinaryTree node, int sum, int level) {
        level++;

        if (node.left != null ) {
            sum += level;
            sum = nodeDepthsSum(node.left, sum, level);
        }

        if (node.right != null) {
            sum += level;
            sum = nodeDepthsSum(node.right, sum, level);
        }

        return sum;
    }

    private static int nodeDepthsHelper(BinaryTree node, int level) {
        if (node == null) {
            return 0;
        }
        return level + nodeDepthsHelper(node.left, level + 1) + nodeDepthsHelper(node.right, level + 1);
    }
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
