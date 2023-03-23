package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class Question11 {
    public static void main(String[] args) {
        Node root = new Node("A");
        Node BNode = root.addChild("B");
        BNode.addChild("E");
        Node FNode = BNode.addChild("F");
        FNode.addChild("I");
        FNode.addChild("J");
        root.addChild("C");
        Node DNode = root.addChild("D");
        Node GNode = DNode.addChild("G");
        GNode.addChild("K");
        DNode.addChild("H");

        List<String> tree = root.depthFirstSearch(new ArrayList<>());
        System.out.println(tree);
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            array.add(name);
            int i = 0;
            while (!children.isEmpty() && i < children.size()) {
                Node childNode = children.get(i);
                childNode.depthFirstSearch(array);
                i++;
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
