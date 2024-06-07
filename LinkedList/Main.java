package LinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertInLinkedList(1, 0);
        singleLinkedList.insertInLinkedList(2, 1);
        singleLinkedList.insertInLinkedList(3, 2);
        singleLinkedList.insertInLinkedList(4, 3);
       singleLinkedList.insertInLinkedList(5, 1);
        singleLinkedList.traverseLinkedList();
        singleLinkedList.searchNode(4);
    }
}


//Assignment question number
//1. Uncomment line 10 "singleLinkedList.insertInLinkedList(5, 1)" and Investigate and fix
    // why when inserting a value at a position that is already occupied, it throws a null pointer exception.

    // The NullPointerException was happening because the code was incorrectly linking the new node to itself instead of inserting it properly into the list. 
    // This caused the list's structure to become invalid, leading to errors when the code tried to traverse or manipulate the list. 
    // The correct approach ensures that the new node is linked between the correct existing nodes, maintaining the list's integrity and 
    // avoiding the null reference errors.