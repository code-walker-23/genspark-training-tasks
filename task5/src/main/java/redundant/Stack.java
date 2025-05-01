package main.java.redundant;

import main.java.structure.Node;

// we are not following DRY principle and we need to use already implemented main.java.linkedlist to avoid main.java.dry
public class Stack {
    private Node head;

    public Stack(){
       head = null;
    }

    public void push(int val){
        if(head == null){
            head = new Node(val);
            return;
        }
        Node newNode = new Node(val);
        newNode.setNext(head);
        head = newNode;
    }

    public void pop(){
        if(head == null){
            System.out.println("Stack is Empty!");
            return;
        }
        int poppedVal = head.getData();
        head = head.getNext();

        System.out.println("popped value : " + poppedVal);
    }

    public void peek(){
        if(head == null){
            System.out.println("Stack is Empty!");
        }
        System.out.println("peek element : " + head.getData()); ;
    }

    public void display(){
        if(head == null){
            System.out.println("Stack is Empty!");
        }
        Node temp = head;

        System.out.println("Stack elements : ");
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public boolean isEmpty(){
        return head == null;
    }
}
