package linkedlists;

import java.util.LinkedList;

public class LinkedListAlgos {

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        Node firstNode = new Node(3);
        Node secondtNode = new Node(4);
        Node thirdNode = new Node(5);
        Node fourthNode = new Node(6);

        linkedList.head = firstNode;
        firstNode.next = secondtNode;
        secondtNode.next = thirdNode;
        thirdNode.next = fourthNode;
        linkedList.displayContents();
        linkedList.deleteBackHalf();
        linkedList.displayContents();
    }
}
