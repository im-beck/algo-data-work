package LinkedList;

// import LinkedList.Node;

public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    //Create a DLL
    public DoublyNode createDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }


    //insert into a DLL
    //0. If link list doesn't
    //1. inserting at the begining
    //2. Inserting at the ending
    //3. Insert anywhere

    public void  insertDLL (int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if(head == null) {
            createDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = tail;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    //Traverse a Linked List
    public void traverseDLL(){
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i != size -1) {
                    System.out.print(" <->");

                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("\n");
    }

        // Reverse Traverse
        public void reverseTraverseDLL() {
            if (tail == null) {
                System.out.println("DLL does not exist");
            } else {
                DoublyNode tempNode = tail;
                while (tempNode != null) {
                    System.out.print(tempNode.value);
                    if (tempNode.prev != null) {
                        System.out.print(" <-> ");
                    }
                    tempNode = tempNode.prev;
                }
            }
            System.out.println();
        }
    
        // Search Node
        public boolean searchNode(int nodeValue) {
            if (head == null) {
                return false;
            } else {
                DoublyNode tempNode = head;
                while (tempNode != null) {
                    if (tempNode.value == nodeValue) {
                        return true;
                    }
                    tempNode = tempNode.next;
                }
                return false;
            }
        }
    
        // Deletion Method
        public void deleteNode(int nodeValue) {
            if (head == null) {
                System.out.println("DLL does not exist");
            } else {
                DoublyNode tempNode = head;
                while (tempNode != null) {
                    if (tempNode.value == nodeValue) {
                        if (tempNode == head) {
                            head = tempNode.next;
                            if (head != null) {
                                head.prev = null;
                            }
                        } else if (tempNode == tail) {
                            tail = tempNode.prev;
                            tail.next = null;
                        } else {
                            tempNode.prev.next = tempNode.next;
                            tempNode.next.prev = tempNode.prev;
                        }
                        size--;
                        return;
                    }
                    tempNode = tempNode.next;
                }
                System.out.println("Node with value " + nodeValue + " not found");
            }
        }
    
        // Delete entire DLL
        public void deleteDLL() {
            head = null;
            tail = null;
            size = 0;
            System.out.println("DLL deleted successfully");
        }
    }
    