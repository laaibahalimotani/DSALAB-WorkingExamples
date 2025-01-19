//Q29 leetcode
public class divideTwoNumbers{
 public static int divide(int dividend,int divisor){
     if(divisor==0){
         throw new ArithmeticException("Division by zero not possible");
     }
     if(dividend==Integer.MIN_VALUE && divisor==-1){
         return Integer.MAX_VALUE;
     }
     boolean isNegative = (dividend<0)^(divisor<0);
     long absDividend= Math.abs((long) dividend);
     long absDivisor= Math.abs((long) divisor);
     int result=0;
     while(absDividend>=absDivisor){
         absDividend-=absDivisor;
         result++;
     }
     return isNegative? -result:result;
 }

    public static void main(String[] args) {
        System.out.println(divide(10,3));
        System.out.println(divide(7,-3));
        System.out.println(divide(-10,2));
        System.out.println(divide(-7,-3));
        System.out.println(divide(0,5));

    }
}