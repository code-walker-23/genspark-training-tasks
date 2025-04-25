public class ReverseLinkedList {
    public static ListNode reverseLL(ListNode prev, ListNode curr) {
        if (curr == null) return prev;
        ListNode nxt = curr.getNext();
        curr.setNext(prev);
        prev = curr;
        curr = nxt;
        return reverseLL(prev, curr);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

}
