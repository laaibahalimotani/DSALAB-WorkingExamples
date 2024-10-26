import java.util.Scanner;
import java.util.stream.IntStream;

public class SumOfNaturalNumbers2 {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter a Number: ");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int sum = IntStream.rangeClosed(1,n).sum();
        System.out.println("The sum of first "+n+" natural numbers is "+sum);
        sc.close();



    }
}
