package Stacks;

public class Main {
    public static void main(String[] args) {
        // Using StackArrays
        System.out.println("Using StackArrays:");
        StackArrays stackArrays = new StackArrays(5);
        stackArrays.push(1);
        stackArrays.push(2);
        stackArrays.push(3);
        System.out.println("Top of stack (StackArrays): " + stackArrays.peek());
        stackArrays.isEmpty();
        stackArrays.isFull();
        stackArrays.pop();
        System.out.println("Top of stack (StackArrays) after pop: " + stackArrays.peek());
        stackArrays.deleteStack();
        
        // Using StackLinkedList
        System.out.println("\nUsing StackLinkedList:");
        StackLinkedList stackLinkedList = new StackLinkedList();
        stackLinkedList.push(1);
        stackLinkedList.push(2);
        stackLinkedList.push(3);
        System.out.println("Top of stack (StackLinkedList): " + stackLinkedList.peek());
        stackLinkedList.isEmpty();
        stackLinkedList.pop();
        System.out.println("Top of stack (StackLinkedList) after pop: " + stackLinkedList.peek());
        stackLinkedList.deleteStack();
    }
}

