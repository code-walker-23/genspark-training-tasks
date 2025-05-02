package main.java.dry;

import main.java.linkedlist.LinkedList;
import main.java.structure.Node;

public class Queue {
    private final LinkedList list;

    public Queue() {
        list = new LinkedList();
    }

    public void enqueue(int val) {
        list.insertLast(val);
    }

    public void dequeue() {
        if (isQueueEmpty()) return;

        int poppedVal = list.getHead().getData();
        System.out.println("Popped value: " + poppedVal);

        list.setHead(list.getHead().getNext());
        list.setSize(list.getSize()-1);
    }

    public void front() {
        if (isQueueEmpty()) return;

        System.out.println("Front element: " + list.getHead().getData());
    }

    public void rear() {
        if (isQueueEmpty()) return;

        Node temp = list.getHead();
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        System.out.println("Rear element: " + temp.getData());
    }

    public void display() {
        if (isQueueEmpty()) return;

        Node temp = list.getHead();
        System.out.print("Queue elements: ");
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public boolean isQueueEmpty() {
        if (list.getHead() == null) {
            System.out.println("Queue is Empty!");
            return true;
        }
        return false;
    }
}
