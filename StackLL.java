import java.util.Scanner;

public class StackLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println(data + " inserted to the stack");
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(top.data + " is deleted");
            top = top.next;
        }
    }

    public void isEmpty() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
    }

    public void top() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element:- " + top.data);
        }
    }

    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + "--->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        StackLL sl = new StackLL();
        Scanner sc = new Scanner(System.in);
        for (;;) {
            System.out.println("Enter your choice:-\n1.)Push\n2.)Pop\n3.)Check Stack empty\n4.)Top of Stack\n5.)Display\n0.)Exit ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element to be pushed:-");
                    int ele = sc.nextInt();
                    sl.push(ele);
                    break;
                case 2:
                    sl.pop();
                    break;
                case 3:
                    sl.isEmpty();
                    break;
                case 4:
                    sl.top();
                    break;
                case 5:
                    sl.display();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
