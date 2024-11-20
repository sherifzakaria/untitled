package leetcode;

public class Problem7 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        printLinkedList(linkedList);

    }

    private static void printLinkedList(MyLinkedList linkedList) {
        System.out.print("Printing linked list: ");
        for (int i = 0; i < linkedList.size; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
    }
}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode prev;
//
//    public ListNode() {
//    }
//
//    public ListNode(int val) {
//        this.val = val;
//    }
//}

//class MyLinkedList {
//
//    ListNode head;
//    ListNode tail;
//    int size;
//
//    public MyLinkedList() {
//        size = 0;
//    }
//
//    public int get(int index) {
//        ListNode node = getNodeAtIndex(index);
//        return node != null ? node.val : -1;
//    }
//
//    public void addAtHead(int val) {
//        ListNode newNode = new ListNode(val);
//        if (size == 0) {
//            head = newNode;
//            tail = newNode;
//        } else if (size == 1) {
//            head = newNode;
//            head.next = tail;
//            tail.prev = head;
//        } else if (size > 1) {
//            head.prev = newNode;
//            newNode.next = head;
//            head = newNode;
//        }
//        size++;
//    }
//
//    public void addAtTail(int val) {
//        ListNode newNode = new ListNode(val);
//        if (size == 0) {
//            head = newNode;
//            tail = newNode;
//        } else if (size == 1) {
//            tail = newNode;
//            tail.prev = head;
//            head.next = tail;
//        } else if (size > 1) {
//            tail.next = newNode;
//            newNode.prev = tail;
//            tail = newNode;
//        }
//        size++;
//    }
//
//    public void addAtIndex(int index, int val) {
//        if (index > size) {
//            return;
//        }
//
//        ListNode newNode = new ListNode(val);
//
//        if (index == 0) {
//            addAtHead(val);
//        } else if (index == size) {
//            addAtTail(val);
//        } else {
//            ListNode currNode = getNodeAtIndex(index);
//            newNode.prev = currNode.prev;
//            newNode.next = currNode;
//            currNode.prev = newNode;
//            newNode.prev.next = newNode;
//            size++;
//        }
//    }
//
//    public void deleteAtIndex(int index) {
//        ListNode node = getNodeAtIndex(index);
//        if (node != null) {
//            if (index == 0) {
//                head = head.next;
//                if (head == null) {
//                    tail = null;
//                } else {
//                    head.prev = null;
//                }
//            } else if (index == size - 1) {
//                tail = tail.prev;
//                if (tail == null) {
//                    head = null;
//                } else {
//                    tail.next = null;
//                }
//            } else {
//                ListNode nextNode = node.next;
//                ListNode prevNode = node.prev;
//                prevNode.next = nextNode;
//                nextNode.prev = prevNode;
//            }
//            node.next = null;
//            node.prev = null;
//            size--;
//        }
//    }
//
//    private ListNode getNodeAtIndex(int index) {
//        if (index > size -1 || index < 0) {
//            return null;
//        }
//        ListNode curr = head;
//        if (size > 0 && index < size) {
//            int i = 0;
//            while (curr != null && i < index) {
//                curr = curr.next;
//                i++;
//            }
//        }
//        return curr;
//    }
//}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */