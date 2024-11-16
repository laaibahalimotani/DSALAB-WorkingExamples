import java.util.Scanner;

class SwapTwoNumbersWithoutThirdVar{
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        a=sc.nextInt();
        System.out.println("Enter b: ");
        b=sc.nextInt();
        System.out.println("Before Swapping: \na: "+a+"\nb: "+b);
        //three different ways with the same result//
        /*a=a+b;
        b=a-b;
        a=a-b;*/
       /*a=a*b;
        b=a/b;
        a=a/b;*/
        //using the xor operator
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("After Swapping: \na: "+a+"\nb: "+b);
        sc.close();

    }
}