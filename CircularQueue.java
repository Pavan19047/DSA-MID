import java.util.Scanner;

public class CircularQueue {
    private static int front, rear, capacity;
    private static int queue[];

    CircularQueue(int size) {
        front = rear = -1;
        queue = new int[capacity];
    }

    static void enqueue(int item) {
        if ((rear + 1) % capacity == front) {
            System.out.println("\nQueue is full\n");
            return;
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % capacity;
            queue[rear] = item;
            capacity++;
            System.out.println(item + " successfully inserted in the queue");
        }
    }

    static void dequeue() {
        if (front == -1) {
            System.out.println("Queue Empty");
            return;
        } else if (front == rear) {
            System.out.println("underflow");
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
            System.out.println(+queue[front] + " dequeued successfully");
        }

        return;
    }

    static void display() {
        if (front == -1) {
            System.out.println("\nQueue is empty\n");
            return;
        } else {
            for (int i = front; i != (rear + 1) % capacity; i = (i + 1) % capacity) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
        return;
    }

    static void QueueFront() {
        if (front == -1) {
            System.out.println("\nQueue is empty\n");
            return;
        } else {
            System.out.println("Front element of the queue is:- " + queue[front]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue:- ");
        int n = sc.nextInt();
        new CircularQueue(n);
        for (;;) {
            System.out.println("\nMenu:\n1.Enqueue \n2.Dequeue \n3.Display \n4.Front element\n5.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the element to be inserted:- ");
                    int ele = sc.nextInt();
                    enqueue(ele);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    QueueFront();
                    break;
                case 5:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
