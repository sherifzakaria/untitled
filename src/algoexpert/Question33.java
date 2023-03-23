package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class Question33 {
    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind();
        unionFind.createSet(5);
        unionFind.createSet(10);
        System.out.println(unionFind.find(5));
        System.out.println(unionFind.find(10));
        unionFind.union(5, 10);
        System.out.println(unionFind.find(5));
        System.out.println(unionFind.find(10));
        unionFind.createSet(20);
        System.out.println(unionFind.find(20));
        unionFind.union(20, 10);
        System.out.println(unionFind.find(5));
        System.out.println(unionFind.find(10));
        System.out.println(unionFind.find(20));

        System.out.println(unionFind.find(0));
        unionFind.union(20, 2);

    }

    static class UnionFind {
        // Write your code here.
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();

        public void createSet(int value) {
            // Write your code here.
            parent.put(value, value);
            rank.put(value, 1);
        }

        public Integer find(int value) {
            // Write your code here.
            if (parent.get(value) != null) {
                while (parent.get(value) != value) {
                    parent.put(value, parent.get(parent.get(value)));
                    value = parent.get(value);
                }
                return value;
            } else {
                return null;
            }
        }

        public void union(int valueOne, int valueTwo) {
            // Write your code here.
            Integer parent1 = find(valueOne);
            Integer parent2 = find(valueTwo);
            if (parent1 != null && parent2 != null && !parent1.equals(parent2)) {
                int rank1 = rank.get(parent1);
                int rank2 = rank.get(parent2);
                if (rank1 >= rank2) {
                    parent.put(valueTwo, parent1);
                    rank.put(valueOne, rank.get(valueOne) + rank.get(valueTwo));
                } else {
                    parent.put(valueOne, parent2);
                    rank.put(valueTwo, rank.get(valueOne) + rank.get(valueTwo));
                }
            }
        }
    }
}
