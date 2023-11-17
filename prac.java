import java.util.Scanner;
public class prac {
    public void pracc(int n, String source,String helper, String destination){
        if(n==1){
            System.out.println("Move disk - 1 from "+source+" to "+destination);
            return;
        }
        pracc(n-1, source, destination, helper);
        System.out.println("Move disk - "+n+" from "+source+" to "+destination);
        pracc(n-1, helper, source, destination);
    }
    public static void main(String[] args) {
        prac p = new prac();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of disks: ");
        int n = sc.nextInt();
        p.pracc(n, "source", "helper", "destination");
    }
}
