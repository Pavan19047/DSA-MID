import java.util.Scanner;

class CircularLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void insertBegin(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        }
        System.out.println(data + " successfully inserted");
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println(data + " successfully inserted");
    }

    public void insertAtPos(int pos, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else if (pos == 1) {
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        } else {
            Node temp = head;
            Node prev = null;
            int count = 1;
            while (temp.next != head && count != pos) {
                count++;
                prev = temp;
                temp = temp.next;
            }
            prev.next = newNode;
            newNode.next = temp;
            // if (temp == head) {
            //     tail = newNode;
            // }
        }
        System.out.println(data + " successfully inserted");
    }

    public void deleteBegin() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == head) {
            System.out.println(head.data + " deleted successfully");
            head = null;
            tail = null;
        } else {
            System.out.println(head.data + " deleted successfully");
            head = head.next;
            tail.next = head;
        }
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == head) {
            System.out.println(head.data + " deleted successfully");
            head = null;
            tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            System.out.println(tail.data + " deleted successfully");
            tail = temp;
            tail.next = head;
        }
    }

    public void deleteAtPos(int pos) {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == head) {
            System.out.println(head.data + " deleted successfully");
            head = null;
            tail = null;
        } else {
            Node temp = head;
            Node prev = null;
            int count = 1;
            while (temp.next != head && count != pos) {
                prev = temp;
                temp = temp.next;
                count++;
            }
            prev.next = temp.next;
            if (temp == tail) {
                tail = prev;
            }
            System.out.println(temp.data + " deleted successfully");
        }
    }

    public void display() {
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            do {
                System.out.print(temp.data + " ---> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("NULL");
        }
    }

    public static void main(String[] args) {
        CircularLinkedList ll = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 9) {
            System.out.println(
                    "1. Insert at begin\n2. Insert at end\n3. Insert at position\n4. Delete at begin\n5. Delete at end\n6. Delete at position\n7. Display\n8. Exit\nEnter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the data");
                    int data = sc.nextInt();
                    ll.insertBegin(data);
                    ll.display();
                    break;
                case 2:
                    System.out.println("Enter the data");
                    data = sc.nextInt();
                    ll.insertEnd(data);
                    ll.display();
                    break;
                case 3:
                    System.out.println("Enter the data");
                    data = sc.nextInt();
                    System.out.println("Enter the position");
                    int pos = sc.nextInt();
                    ll.insertAtPos(pos, data);
                    ll.display();
                    break;
                case 4:
                    ll.deleteBegin();
                    ll.display();
                    break;
                case 5:
                    ll.deleteEnd();
                    ll.display();
                    break;
                case 6:
                    System.out.println("Enter the position");
                    pos = sc.nextInt();
                    ll.deleteAtPos(pos);
                    ll.display();
                    break;
                case 7:
                    ll.display();
                    break;
                case 8:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
