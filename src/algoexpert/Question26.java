package algoexpert;

public class Question26 {

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(5);
        tree.insert(13);
        tree.insert(22);
        tree.insert(1);
        tree.insert(14);
        tree.insert(12);
        tree.remove(5);
        tree.remove(5);
        tree.remove(12);
        tree.remove(13);
        tree.remove(14);
        tree.remove(2);
        tree.remove(1);
        tree.remove(15);
        System.out.println();
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = new BST(value);
                        return this;
                    }
                    currentNode = currentNode.left;
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = new BST(value);
                        return this;
                    }
                    currentNode = currentNode.right;
                }
            }
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            BST currentNode = this;
            while (currentNode != null) {
                if (currentNode.value == value) {
                    return true;
                } else if (value < currentNode.value) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }
            return false;
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            if (this.left != null || this.right != null) {
                BST rootNode = this;
                if (rootNode.value == value) {
                    deleteRoot(rootNode);
                    return this;
                } else {
                    BST newParent = rootNode;
                    BST currentNode = rootNode;

                    while (currentNode != null) {
                        if (value < currentNode.value) {
                            newParent = currentNode;
                            currentNode = currentNode.left;
                        } else if (value > currentNode.value) {
                            newParent = currentNode;
                            currentNode = currentNode.right;
                        } else {
                            deleteNode(newParent, currentNode);
                            return this;
                        }
                    }
                }
            }
            return this;
        }

        private void deleteNode(BST parentNode, BST currentNode) {
            if (currentNode.value < parentNode.value) {
                if (currentNode.left == null && currentNode.right == null) {
                    parentNode.left = null;
                } else if (currentNode.right == null) {
                    parentNode.left = currentNode.left;
                } else {
                    BST newNode = currentNode.right;
                    parentNode.left = newNode;
                    newNode.left = currentNode.left;
                }
            } else {
                if (currentNode.left == null && currentNode.right == null) {
                    parentNode.right = null;
                } else if (currentNode.right == null) {
                    parentNode.right = currentNode.left;
                } else {
                    BST newNode = currentNode.right;
                    parentNode.right = newNode;
                    newNode.left = currentNode.left;
                }
            }
        }

        private void deleteRoot(BST rootNode) {
            BST currentLeft = rootNode.left;
            BST currentRight = rootNode.right;
            if (currentRight != null) {
                BST newRoot = currentRight;
                BST newRootOldParent = null;
                while (newRoot.left != null) {
                    newRootOldParent = newRoot;
                    newRoot = newRoot.left;
                }
                this.value = newRoot.value;
                if (newRootOldParent != null) {
                    newRootOldParent.left = null;
                } else {
                    this.right = currentRight.right;
                }
            } else {
                this.value = currentLeft.value;
                this.left = currentLeft.left;
            }
        }
    }
}
