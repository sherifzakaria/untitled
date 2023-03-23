package algoexpert;

public class Question9 {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.next = new LinkedList(1);
        linkedList.next.next = new LinkedList(3);
        linkedList.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next = new LinkedList(4);
        linkedList.next.next.next.next.next = new LinkedList(4);

        LinkedList removedDuplicatedList = removeDuplicatesFromLinkedList(linkedList);
        while (removedDuplicatedList != null) {
            System.out.println(removedDuplicatedList.value);
            removedDuplicatedList = removedDuplicatedList.next;
        }
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        LinkedList node = linkedList;
        while (node != null && node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                continue;
            }
            node = node.next;
        }

        return linkedList;
    }
}
