package main.java;

//import main.java.redundant.Queue;
import main.java.dry.Queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        System.out.println("== Queue Operations ==");
        System.out.println("→ Enqueuing: 1, 2, 3, 4");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println("\n→ Queue contents:");
        queue.display();

        System.out.println("\n→ Front element:");
        queue.front();

        System.out.println("\n→ Rear element:");
        queue.rear();

        System.out.println("\n→ Dequeuing two elements:");
        queue.dequeue();
        queue.dequeue();

        System.out.println("\n→ Enqueuing: 4, 5");
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("\n→ Front element:");
        queue.front();

        System.out.println("\n→ Rear element:");
        queue.rear();

        System.out.println("\n→ Final Queue contents:");
        queue.display();
    }
}
