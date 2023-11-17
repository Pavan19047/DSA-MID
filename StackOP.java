
import java.util.Scanner;
public class StackOP {
    public static void main(String[] args) {
        Stack s = new Stack();
        for(;;){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice:-\n1.)Push\n2.)Pop\n3.)Check Stack empty\n4.)Top of Stack\n5.)Display\n0.)Exit ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element to be pushed:-");
                    int ele = sc.nextInt();
                    if(s.push(ele)){
                        System.out.println("Element "+ele+" pushed successfully");
                    }
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.isEmpty();
                    break;
                case 4:
                    s.top();
                    break;
                case 5:
                    s.display();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

class Stack{
    int top;
    final int size=5;
    int[] stack = new int[size];
    Stack(){
        top=-1;
    }
    boolean isEmpty(){
        if (top<0){
            System.out.println("Stack is Empty");
            return true;
        }else{
            System.out.println("Stack is not empty");
            return false;
        }
    }
    boolean push(int item){
        if(top==size-1){
            System.out.println("Stack is full");
            return false;
        }else{
            top++;
            stack[top] = item;
            return true;
        }
    }
    boolean pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return false;
        }else{
            System.out.println("Item popped:- "+stack[top--]);
            return true;
        }
    }
    boolean top(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return false;
        }else{
            System.out.println("Top element:- "+stack[top]);
            return true;
        }
    }
    void display(){
        if(isEmpty()){
            System.out.println("Stack underflow");
        
        }else{
            System.out.println("Printing Stack elements...");
            for(int i=top;i>=0;i--){
                System.out.println(" "+stack[i]+"\n|__|");
            }
            System.out.println();
        }
    }
}
