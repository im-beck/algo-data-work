package Stacks;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class StackLinkedList {
    Node top;

    public StackLinkedList() {
        this.top = null;
        System.out.println("The stack is created using linked list");
    }

    // Check if it is empty
    public boolean isEmpty() {
        if (top == null) {
            System.out.println("Stack is empty");
            return true;
        } else {
            System.out.println("Stack is not empty");
            return false;
        }
    }

    // Implement push method
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println("The value is successfully inserted");
    }

    // Implement pop method
    public int pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty, cannot pop");
            return -1;
        } else {
            int value = top.value;
            top = top.next;
            System.out.println("The value is successfully popped");
            return value;
        }
    }

    // Implement peek method
    public int peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty, cannot peek");
            return -1;
        } else {
            return top.value;
        }
    }

    // Implement deleteStack method
    public void deleteStack() {
        top = null;
        System.out.println("The stack is successfully deleted");
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(10);
        stack.push(20);
        System.out.println("Top of stack: " + stack.peek());
        stack.pop();
        System.out.println("Top of stack: " + stack.peek());
        stack.deleteStack();
    }
}
