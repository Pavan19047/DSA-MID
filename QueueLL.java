import java.util.Scanner;

public class QueueLL {
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
        private Node head = null;
        public void enqueue(int data){
            Node newNode = new Node(data);
            newNode.data=data;
            if(head==null){
                head=newNode;
                System.out.println(head.data+" successfully inserted to the queue");
            }else{
                newNode.next=head;
                head=newNode;
                 System.out.println(head.data+" successfully inserted to the queue");
            }
        }
        public void dequeue(){
            if(head==null){
                System.out.println("Queue is empty");
            }
            else{
                System.out.println(head.data+" deleted from queue");
                head=head.next;
            }
        }
        public void display(){
            if(head==null){
                System.out.println("List is empty");
            }
            else{
              Node temp = head;
              while(temp!=null){
                System.out.print(temp.data+"--->");
                temp=temp.next;
              }
              System.out.println("NULL");
            }
        }
        public void front(){
            if(head==null){
                System.out.println("List is empty");
            }
            else{
                System.out.println(head.data+" is the front element");
            }
        }
        public void rear(){
            if(head==null){
                System.out.println("List is empty");
            }
            else{
                Node temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                System.out.println(temp.data+" is the rear element");
            }
        }
        public static void main(String[] args) {
            //Generate the rest of the code
            QueueLL q1 = new QueueLL();
            Scanner scanner = new Scanner (System.in);
            int choice;
            do{
                System.out.println("1. Enqueue");
                System.out.println("2. Dequeue");
                System.out.println("3. Display");
                System.out.println("4. Front");
                System.out.println("5. Rear");
                System.out.println("6. Exit");
                System.out.println("Enter your choice:- ");
                choice = scanner.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("Enter the element to be inserted:- ");
                        int element = scanner.nextInt();
                        q1.enqueue(element);
                        break;
                    case 2:
                        q1.dequeue();
                        break;
                    case 3:
                        q1.display();
                        break;
                    case 4:
                        q1.front();
                        break;
                    case 5:
                        q1.rear();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }while(choice!=6);
            scanner.close();
        }
    }
