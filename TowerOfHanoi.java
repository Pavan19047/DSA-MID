import java.util.Scanner;

public class TowerOfHanoi {
    public void towerOfHanoiMethod(int n, String source, String helper, String destination) { //source-a,helper-b,destination-c
        if (n == 1) {
            System.out.println("Move disk - 1 from pole " + source + " to " + destination);
            return;
        }
        towerOfHanoiMethod(n - 1, source, destination, helper);
        System.out.println("Move disk - " + n + " from pole " + source + " to " + destination);
        towerOfHanoiMethod(n - 1, helper, source, destination);
    }

    public static void main(String[] args) {
        int n;
        TowerOfHanoi t = new TowerOfHanoi();
        System.out.print("Enter number of disks : ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t.towerOfHanoiMethod(n, "source", "helper", "destination");
        sc.close();
    }
}
