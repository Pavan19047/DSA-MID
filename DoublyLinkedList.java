
import java.util.*;

class Node {
    Node prev;
    int data;
    Node next;

    Node(int value) {

        prev = null;

        data = value;

        next = null;
    }
}

class DoublyLinkedList {

    static Node head = null;
    static Node tail = null;

    static void insertAtBeginning(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    static void insertAtEnd(int data) {
        Node temp = new Node(data);
        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    static void insertAtPosition(int data, int position) {
        Node temp = new Node(data);
        if (position == 1) {
            insertAtBeginning(data);
        } else {
            Node current = head;
            int currPosition = 1;
            while (current != null
                    && currPosition < position) {
                current = current.next;
                currPosition++;
            }
            if (current == null) {
                insertAtEnd(data);
            } else {
                temp.next = current;
                temp.prev = current.prev;
                current.prev.next = temp;
                current.prev = temp;
            }
        }
    }

    static void deleteAtBeginning() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

    static void deleteAtEnd() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

    static void deleteAtSpecificPosition(int pos) {
        if (head == null) {
            return;
        }

        if (pos == 1) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count != pos) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position wrong");
            return;
        }

        if (current == tail) {
            deleteAtEnd();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Drivers code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(;;){
            
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete at beginning");
            System.out.println("5. Delete at end");
            System.out.println("6. Delete at position");
            System.out.println("7. Display");
            System.out.println("8. Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter the value to be inserted");
                    int value = sc.nextInt();
                    insertAtBeginning(value);
                    break;
                case 2:
                    System.out.println("Enter the value to be inserted");
                    value = sc.nextInt();
                    insertAtEnd(value);
                    break;
                case 3:
                    System.out.println("Enter the value to be inserted");
                    value = sc.nextInt();
                    System.out.println("Enter the position");
                    int position = sc.nextInt();
                    insertAtPosition(value, position);
                    break;
                case 4:
                    deleteAtBeginning();
                    break;
                case 5:
                    deleteAtEnd();
                    break;
                case 6:
                    System.out.println("Enter the position");
                    position = sc.nextInt();
                    deleteAtSpecificPosition(position);
                    break;
                case 7:
                    display(head);
                    break;
                case 8:
                    System.exit(0);
                    sc.close();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
           
        }
    }
}
