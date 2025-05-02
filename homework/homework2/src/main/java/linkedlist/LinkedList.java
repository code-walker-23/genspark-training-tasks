package main.java.linkedlist;

import main.java.structure.Node;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // Insert at any position
    public void insert(int data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node newNode = new Node(data);

        if (position == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) temp = temp.getNext();
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        size++;
    }

    // Insert at the end
    public void insertLast(int data) {
        insert(data, size);
    }

    // Delete at specific position
    public void delete(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        if (position == 0) {
            Node toDelete = head;
            head = head.getNext();
            toDelete.setNext(null);
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.getNext();
            }
            Node toDelete = temp.getNext();
            temp.setNext(toDelete.getNext());
            toDelete.setNext(null);
        }
        size--;
    }

    // Delete last element
    public void deleteLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        delete(size - 1);
    }

    // Delete the middle node
    public void deleteMiddle() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        int middleIndex = size / 2; // For even size, deletes the second middle
        delete(middleIndex);
    }

    // Find middle node value
    public int findMiddle() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow.getData();
    }

    // Print the linked list
    public void printList() {
        Node temp = head;
        System.out.print("DRY.LinkedList: ");
        while (temp != null) {
            System.out.print(temp.getData() + (temp.getNext() != null ? " -> " : ""));
            temp = temp.getNext();
        }
        System.out.println();
    }

    // Get size of the list
    public int getSize() {
        return size;
    }
    public void setSize(int size){
        this.size = size;
    }
    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }
}