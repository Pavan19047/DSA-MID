import java.util.Scanner;
public class Factorial {
    int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        Factorial f = new Factorial();
        System.out.println("Factorial of " + n + " is " + f.fact(n));
    }
}
