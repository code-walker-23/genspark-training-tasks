package main.java.dry;

import main.java.linkedlist.LinkedList;
import main.java.structure.Node;

public class Stack {
    private final LinkedList list;

    public Stack(){
        list = new LinkedList();
    }

    public void push(int val){
        list.insert(val,0);
    }

    public void pop(){
        if(list.getHead() == null){
            System.out.println("Stack is Empty!");
            return;
        }
        int poppedVal = list.getHead().getData();
        System.out.println("popped value : " + poppedVal);

        list.setHead(list.getHead().getNext());
    }

    public void peek(){
        if(list.getHead() == null){
            System.out.println("Stack is Empty!");
            return;
        }
        System.out.println("peek element : " + list.getHead().getData()); ;
    }

    public void display(){
        if(list.getHead() == null){
            System.out.println("Stack is Empty!");
            return;
        }
        Node temp = list.getHead();

        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public boolean isEmpty(){
        return list.getHead() == null;
    }
}

