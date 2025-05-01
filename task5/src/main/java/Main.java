package main.java;

import main.java.dry.Stack;
// import main.java.redundant.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("== Stack Operations ==");
        System.out.println("→ Pushing: 1, 2, 3, 4");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("\n→ Stack contents:");
        stack.display();

        System.out.println("\n→ Peeking top element:");
        stack.peek();

        System.out.println("\n→ Popping two elements:");
        stack.pop();
        stack.pop();

        System.out.println("\n→ Pushing: 4, 5");
        stack.push(4);
        stack.push(5);

        System.out.println("\n→ Peeking top element:");
        stack.peek();

        System.out.println("\n→ Final Stack contents:");
        stack.display();
    }
}
