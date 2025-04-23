public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("== Inserting elements ==");

        System.out.println("Inserting 10 at position 0 (head)");
        list.insert(10, 0);

        System.out.println("Inserting 20 at position 1 (tail)");
        list.insert(20, 1);

        System.out.println("Inserting 30 at position 2 (tail)");
        list.insert(30, 2);

        System.out.println("Inserting 15 at position 1 (between 10 and 20)");
        list.insert(15, 1);

        System.out.println("Inserting 40 at last using insertLast()");
        list.insertLast(40);

        list.printList(); // Expected: 10 -> 15 -> 20 -> 30 -> 40

        System.out.println("\n== Deleting specific element at position 2 ==");
        list.delete(2); // Deletes 20
        list.printList(); // Expected: 10 -> 15 -> 30 -> 40

        System.out.println("\n== Deleting last element ==");
        list.deleteLast(); // Deletes 40
        list.printList(); // Expected: 10 -> 15 -> 30

        System.out.println("\n== Deleting middle element ==");
        list.deleteMiddle(); // Deletes 15
        list.printList(); // Expected: 10 -> 30

        System.out.println("\n== Finding middle element ==");
        System.out.println("Middle value: " + list.findMiddle()); // Should print 10

        System.out.println("\n== Final List ==");
        list.printList(); // Final state of the list

        System.out.println("Size: " + list.getSize()); // Should be 2
    }
}
