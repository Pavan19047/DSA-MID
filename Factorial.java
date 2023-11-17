public class Factorial {
    int fact(int n){
        if(n==0 || n==1){
            return 1;
        }
        else{
            return n*fact(n-1);
        }
    }
    public static void main(String[] args) {
        int n=5;
        Factorial f = new Factorial();
        System.out.println("Factorial of "+n+" is "+f.fact(n));
    }
}
