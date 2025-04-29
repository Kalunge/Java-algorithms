package pattern.inPlaceLL;



public class ReverseSecondHalf {
    public static ListNodeDemo reverseSecondHalf(ListNodeDemo head) {
        if (head == null || head.next == null) {
            return head; // No need to process if list is empty or has one node
        }

        // Step 1: Find the middle of the list
        ListNodeDemo slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // Moves one step
            fast = fast.next.next; // Moves two steps
        }

        // Step 2: Reverse the second half of the list
        ListNodeDemo secondHalfHead = reverseList(slow);

        // Step 3: Attach the reversed second half back to the list
        ListNodeDemo temp = head;
        while (temp.next != slow) { // Traverse to the node before the middle
            temp = temp.next;
        }
        temp.next = secondHalfHead;

        return head;
    }

    private static ListNodeDemo reverseList(ListNodeDemo head) {
        ListNodeDemo prev = null;
        ListNodeDemo curr = head;

        while (curr != null) {
            ListNodeDemo next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; // New head of the reversed list
    }

    public static void printList(ListNodeDemo head) {
        ListNodeDemo temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example: Creating a linked list 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNodeDemo head = new ListNodeDemo(1);
        head.next = new ListNodeDemo(2);
        head.next.next = new ListNodeDemo(3);
        head.next.next.next = new ListNodeDemo(4);
        head.next.next.next.next = new ListNodeDemo(5);

        System.out.println("Original List:");
        printList(head);

        // Reverse the second half of the list
        head = reverseSecondHalf(head);

        System.out.println("List After Reversing Second Half:");
        printList(head);
    }
}

class ListNodeDemo {
    int val;
    ListNodeDemo next;

    ListNodeDemo(int val) {
        this.val = val;
        this.next = null;
    }
}
