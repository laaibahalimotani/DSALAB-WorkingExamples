public class FindSecondMax {
    public static int findSecondMax(int [] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int k: arr){
            if(k>max){
                secondMax=max;
                max=k;
            }else if(k>secondMax && k!=max){
                secondMax=k;
            }
        }
        //edge case
        if(secondMax==Integer.MIN_VALUE){
            throw new IllegalArgumentException("No second max value");
        }
        return secondMax;
    }

    public static void main(String[] args) {
        int []arr={1,45,3,42,56,31,89};
        int secondMax= findSecondMax(arr);
        System.out.println(secondMax);
    }
}
