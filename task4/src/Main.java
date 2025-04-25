public class Main {
    public static void main(String[] args) {
        int n = 5;

        System.out.println("Descending Order:");
        DescendingOrder.descendingOrder(n);
        System.out.println();

        System.out.println("Ascending Order:");
        AscendingOrder.ascendingOrder(n);
        System.out.println();

        System.out.println("Both Ascending and Descending:");
        CombinedOrder.combineOrder(n);
        System.out.println();

        System.out.println("Print Pattern Using Recursion (Descending Stars):");
        StarPrinterDescending.printPatternDescending(n);
        System.out.println();

        System.out.println("Print Pattern Using Recursion (Ascending Stars):");
        StarPrinterAscending.printPatternAscending(n);
        System.out.println();

        System.out.println("Print Pattern Using Recursion (Number Pyramid):");
        NumberPyramid.printPatternNumberPyramid(n);
        System.out.println();

        System.out.println("Reverse the Linked List Using Recursion:");
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));

        System.out.println("Before reversing the linked list:");
        ReverseLinkedList.printList(head);

        head = ReverseLinkedList.reverseLL(null, head);

        System.out.println("After reversing the linked list:");
        ReverseLinkedList.printList(head);
        System.out.println();

        System.out.println("Reverse the Array Using Recursion:");
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Before reversing the array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        ReverseArray.reverseArr(arr, 0, arr.length - 1);

        System.out.println("After reversing the array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
