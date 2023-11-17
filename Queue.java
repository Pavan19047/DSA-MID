import java.util.Scanner;
public class Queue {
    private static int front,rear,size,capacity;
    private static int queue[];

    Queue(int size){
        front=rear=0;
        capacity = size;
        queue = new int[capacity];
    }
    static void enqueue(int item){
        if(capacity==size){
            System.out.println("\nQueue is full\n");
            return;
        }else{
            queue[rear] = item;
            rear++;
            size++;
            System.out.println(+item+" successfully inserted in the queue");
        }
        return;
    }
    static void dequeue(){
        if(front==rear){
            System.out.println("Queue Empty");
            return;
        }else{
            System.out.println(+queue[front]+" dequeued successfully");
            for(int i=front;i<rear-1;i++){
                queue[i] = queue[i+1];
            }
        }
        rear--;
        size--;
        return;
    }

    static void display(){
        if(front==capacity){
            System.out.println("\nQueue is empty\n");
            return;
        }else{
            for(int i=front;i<rear;i++){
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
        return;
    }
    static void QueueFront(){
        if(front==rear){
            System.out.println("\nQueue is empty\n");
            return;
        }else{
            System.out.println("Front element of the queue is:- "+queue[front]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue:- ");
        int n = sc.nextInt();
        new Queue(n);
        for(;;){
            System.out.println("\nMenu:\n1.Enqueue \n2.Dequeue \n3.Display \n4.Front element\n5.Exit");
            int choice = sc.nextInt();
            switch(choice){
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
