
import java.util.Scanner;

 class SupprtTicketSystem {
    private static int front, rear, size, capacity;
    private static String[] ticketQueue;

    SupprtTicketSystem(int size) {
        front = rear = 0;
        capacity = size;
        ticketQueue = new String[capacity];
    }

    static void enqueue(String ticket) {
        if (size == capacity) {
            System.out.println("Ticket queue is full. Cannot add more tickets.");
        } else {
            ticketQueue[rear] = ticket;
            rear++;
            size++;
            System.out.println("Ticket #" + ticket + " successfully added to the queue.");
        }
    }

    static void dequeue() {
        if (size == 0) {
            System.out.println("Ticket queue is empty. No tickets to dequeue.");
        } else {
            System.out.println("Support agent is resolving Ticket #" + ticketQueue[front]);
            for (int i = 0; i < rear - 1; i++) {
                ticketQueue[i] = ticketQueue[i + 1];
            }
            rear--;
            size--;
        }
    }

    static void displayQueue() {
        if (size == 0) {
            System.out.println("Ticket queue is empty.");
        } else {
            System.out.print("Current Ticket Queue: ");
            for (int i = front; i < rear; i++) {
                System.out.print(ticketQueue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the maximum number of tickets in the queue:");
        int maxTickets = sc.nextInt();
        new SupprtTicketSystem(maxTickets);

        while (true) {
            System.out.println("\nMenu:\n1. Add Ticket\n2. Resolve Ticket\n3. Display Queue\n4. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the ticket number:");
                    sc.nextLine(); // consume the newline character left by nextInt()
                    String ticketNumber = sc.nextLine();
                    enqueue(ticketNumber);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    displayQueue();
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
