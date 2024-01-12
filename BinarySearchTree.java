import java.util.Scanner;

public class BinarySearchTree {
   public class Node{
        int data;
        Node left;
        Node right;

       public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public Node root;
    public BinarySearchTree(){
        root = null;
    }
    public void insert(int data){
        Node newNode = new Node(data);
        if(root==null){
            root = newNode;
            return;
        }
        else{
            Node current = root, parent = null;
            while (current!=null) {
                parent = current;
                if(data < current.data){
                    current = current.left;
                    if(current == null){
                        parent.left = newNode;
                    }
                }
                else{
                    current = current.right;
                    if(current==null){
                        parent.right = newNode;
                    }
                }
            }
        }
    }
    public void inOrderTraversal(Node node){
        if(root==null){
            System.out.println("Tree Empty");
        }
        else{
            if(node.left!=null){
                inOrderTraversal(node.left);
            }
            System.out.print(node.data+" ");
            if(node.right!=null){
                inOrderTraversal(node.right);
            }
        }
    }
    public void preOrderTraversal(Node node){
        if(root==null){
            System.out.println("Tree Empty");
        }
        else{
             System.out.print(node.data+" ");
            if(node.left!=null){
                inOrderTraversal(node.left);
            }
            if(node.right!=null){
                inOrderTraversal(node.right);
            }
        }
    }

    public void postOrderTraversal(Node node){
         if(root==null){
            System.out.println("Tree Empty");
        }
        else{ 
            if(node.left!=null){
                inOrderTraversal(node.left);
            }
            if(node.right!=null){
                inOrderTraversal(node.right);
            }
            System.out.print(node.data+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int choice = 0;
        do {
            System.out.println("Binary Search Tree Menu\n1. Insert a node\n2. Inorder Traversal\n3. Preorder Traversal\n4. Postorder Traversal\n5. Exit\nEnter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the node value: ");
                    int value = sc.nextInt();
                    bst.insert(value);
                    break;
                case 2:
                    System.out.println("Inorder Traversal:");
                    bst.inOrderTraversal(bst.root);
                    break;
                case 3:
                    System.out.println("Preorder Traversal:");
                    bst.preOrderTraversal(bst.root);
                    break;
                case 4:
                    System.out.println("Postorder Traversal:");
                    bst.postOrderTraversal(bst.root);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }
}
