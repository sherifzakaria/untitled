package leetcode;

import java.util.*;

public class Problem7A {
    public static void main(String[] args) {
//        List<String> a = new ArrayList<>();
//        int[] students = new int[]{1, 1, 0, 0, 0, 1, 1};
//        Deque<Integer> a1 = new ArrayDeque<>();
//        a1.add(1);
//        Map<Integer, Integer> count = new HashMap<>();
//        count.put(1, 1);
//        count.getOrDefault(2,1);
//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(7);
//        linkedList.addAtHead(2);
//        linkedList.addAtHead(1);
//        linkedList.addAtIndex(3, 0);
//        printLinkedList(linkedList);
//        linkedList.deleteAtIndex(2);
//        printLinkedList(linkedList);
//        linkedList.addAtHead(6);
//        printLinkedList(linkedList);
//        linkedList.addAtTail(4);
//        printLinkedList(linkedList);
//        System.out.println(linkedList.get(4));
//        linkedList.addAtHead(4);
//        linkedList.addAtIndex(5, 0);
//        linkedList.addAtHead(6);
//        printLinkedList(linkedList);
        countStudents(new int[] {1,1,1,0,0,1}, new int[] {1,0,0,0,1,1});
    }
    // 6,1,2,0,4

    public static int countStudents(int[] students, int[] sandwiches) {
        int studentsLength = students.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int s : students) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        for (int s : sandwiches) {
            if (count.get(s) > 0) {
                count.put(s, count.get(s) - 1);
                studentsLength--;
            } else {
                break;
            }
        }

        Queue<String> a = new LinkedList<>();
        Map<Integer, Integer> b = new HashMap<>();

        return studentsLength;
    }
    private static void printLinkedList(MyLinkedList linkedList) {
        System.out.print("Printing linked list: ");
        "asdsad".chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
        for (int i = 0; i < linkedList.size; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {

    private ListNode head;
    private ListNode tail;
    int size;

    public MyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode node = getNodeAtIndex(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = tail;
        newNode.prev = tail.prev;
        newNode.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode(val);
        if (index == size) {
            ListNode prevNode = tail.prev;
            newNode.next = tail;
            newNode.prev = prevNode;
            prevNode.next = newNode;
            tail.prev = newNode;
            size++;
            return;
        }

        ListNode nodeAtIndex = getNodeAtIndex(index);
        if (nodeAtIndex == null) {
            return;
        }

        if (nodeAtIndex != head && nodeAtIndex.prev != null) {
            newNode.next = nodeAtIndex;
            newNode.prev = nodeAtIndex.prev;
            nodeAtIndex.prev.next = newNode;
            nodeAtIndex.prev = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode nodeToBeDeleted = getNodeAtIndex(index);

        if (nodeToBeDeleted == null) {
            return;
        }

        ListNode nextNode = nodeToBeDeleted.next;
        ListNode prevNode = nodeToBeDeleted.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        nodeToBeDeleted.next = null;
        nodeToBeDeleted.prev = null;
        size--;
    }

    private ListNode getNodeAtIndex(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        ListNode curr = head.next;
        while (curr != null && index > 0 && curr != tail) {
            curr = curr.next;
            index--;
        }

        return curr;
    }
}
