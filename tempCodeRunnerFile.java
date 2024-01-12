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