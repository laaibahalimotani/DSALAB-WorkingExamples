import java.util.Scanner;

public class ThreeDecimalPlaceCheck {
    public static void main(String[] args) {
        float a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        a=sc.nextFloat();
        System.out.println("Enter b: ");
        b=sc.nextFloat();
        //multiplying by 1000 and using math.round to round the value off to three decimal places
        if((Math.round(a*1000))==(Math.round(b*1000))) {
            System.out.println("a and b are the same up to three decimal places");
        }
        else {
            System.out.println("a and b are different");
        }
        sc.close();

    }
}
