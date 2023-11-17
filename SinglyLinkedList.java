import java.util.Scanner;
public class SinglyLinkedList{
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
        
    }
    public Node head = null;
    public Node tail = null;

    public void insert_begin(int data){
        Node newNode = new Node(data);
        newNode.data=data;
        if(head==null){
            head = newNode;
            tail = newNode;
            tail.next=null;
        }else{
            newNode.next=head;
            head=newNode;
            System.out.println(+data+" inserted successfully");
        }
    }
    public void insert_end(int data){
        Node newNode = new Node(data);
        newNode.data=data;
        if(head==null){
            head = newNode;
            tail = newNode;
            tail.next=null;
        }else{
            tail.next=newNode;
            tail=newNode;
            System.out.println(data+" inserted at the end");
        }
    }
    public void insert_at_pos(int data, int pos){
        Node newNode = new Node(data);
        newNode.data=data;
        if(pos==1){
            newNode.next=head;
            head=newNode;
        }
        Node prev = head;
        for(int i=1;i<pos-1;i++){
            prev=prev.next;
        }
        newNode.next=prev.next;
        prev.next=newNode;
        System.out.println(data+" inserted at position "+pos);
    }
    public void delete_begin(){
        if(head==null){
            System.out.println("List is empty");
        }
        else if(head.next==null){
            System.out.println(head.data+" deleted successfully");
            head=null;
            tail=null;  
        }
        else{
            System.out.println(head.data+" deleted successfully");
            head=head.next;
        }
    }
    public void delete_end(){
        if (head==null) {
            System.out.println("List is empty");
        }
        else if(head.next==null){
            System.out.println(tail.data+" deleted successfully");
            head=tail=null;
        }
        else{
            Node temp = head;
            while (temp.next!=tail) {
                temp=temp.next;
            }
            System.out.println(tail.data+" deleted successfully");
            tail=temp;
            tail.next=null;
            
        }
    }
    public void delete_at_pos(int pos){
        int count=1;
        Node temp = head;
        Node prev = null;
        if(head==null){
            System.out.println("List is empty");
        }
        else if(head.next==null){
            head=null;
        }else if(pos==0){
            head=head.next;
        }
        else{
            while(temp!=null && count!=pos){
                prev=temp;
                temp=temp.next;
                count++;
            }
            prev.next=temp.next;
            System.out.println(temp.data+" deleted successfully");
        }
    }
    public void display(){
        Node temp = head;
        if(head==null){
            System.out.println("List is empty");
        }else{
            while(temp!=null){
                System.out.print(temp.data+" --->");
                temp=temp.next;
            }
            System.out.println("NULL");
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice!=9) {
            System.out.println("1. Insert at begin\n2. Insert at end\n3. Insert at position\n4. Delete at begin\n5. Delete at end\n6. Delete at position\n7. Display\n8. Exit\nEnter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the data");
                    int data = sc.nextInt();
                    ll.insert_begin(data);
                    ll.display();
                    break;
                case 2:
                    System.out.println("Enter the data");
                    data = sc.nextInt();
                    ll.insert_end(data);
                    ll.display();
                    break;
                case 3:
                    System.out.println("Enter the data");
                    data = sc.nextInt();
                    System.out.println("Enter the position");
                    int pos = sc.nextInt();
                    ll.insert_at_pos(data, pos);
                    ll.display();
                    break;
                case 4:
                    ll.delete_begin();
                    ll.display();
                    break;
                case 5:
                    ll.delete_end();
                    ll.display();
                    break;
                case 6:
                    System.out.println("Enter the position");
                    pos = sc.nextInt();
                    ll.delete_at_pos(pos);
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
