package main.java.redundant;

import main.java.structure.Node;

public class Queue {
    private Node head;

    public Queue() {
        head = null;
    }

    public void enqueue(int val) {
        if(head == null){
            head = new Node(val);
            return;
        }

        Node temp = head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }

        temp.setNext(new Node(val));
    }

    public void dequeue() {
        if (isQueueEmpty()) return;

        int poppedVal = head.getData();
        System.out.println(poppedVal);

        head = head.getNext();
    }

    public void front() {
        if (isQueueEmpty()) return;

        System.out.println(head.getData());
    }

    public void rear() {
        if (isQueueEmpty()) return;

        Node temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        System.out.println(temp.getData());
    }

    public void display() {
        if (isQueueEmpty()) return;

        Node temp = head;
        System.out.print("Queue elements: ");
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public boolean isQueueEmpty() {
        if (head == null) {
            System.out.println("Queue is Empty!");
            return true;
        }
        return false;
    }
}
