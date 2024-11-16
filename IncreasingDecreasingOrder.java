import java.util.Scanner;

public class IncreasingDecreasingOrder {
    static void CheckIncDec(int a, int b, int c) {
        if (a > b && b > c) {
            System.out.println("decreasing");
        } else if (a < b && b < c) {
            System.out.println("Increasing");
        } else {
            System.out.println("Neither increasing nor decreasing ");
        }
    }
    public static void main(String[] args) {
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a, b and c: ");
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();


        /*System.out.println("Enter b: ");
        System.out.println("Enter c: ");*/

        CheckIncDec(a,b,c);
        sc.close();
    }
     }

