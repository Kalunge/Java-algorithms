package pattern.inPlaceLL;

public class Demo {
    public static ListNode reverseNodes(ListNode head) {

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {

            ListNode next = current.next;

            // reverse the current node to point to the prev
            current.next = prev;

            prev = current;
            current = next;

        }

        return prev;
    }


    public static ListNode reverseSecondHalf(ListNode head) {
        // identify center node.
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode seconfHalfHead = reverseNodes(slow.next);

        ListNode temp = head;
        while (temp.next != slow) {
            temp = temp.next;
        }

        temp.next = seconfHalfHead;

        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;

        }

        System.out.print("Null");
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode current = head;
        int length = 1;

        while (current.next != null) {
            current = current.next;
            length++;
        }

        // form a circular LL
        current.next = head;

        k = k % length;
        int newHeadPosition = length - k;

        ListNode newTail = head;

        int i = 1;

        while (i < newHeadPosition) {
            newTail = newTail.next;
            i++;
        }

        head = newTail.next;
        newTail.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        head = reverseSecondHalf(head);

        printList(head);

        head = rotateRight(head, 2);
        System.out.println("Rotated");
        printList(head);
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode head;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
        this.head = null;
    }
}
