public class FindingMaximum {
    public static int findMax(int [] arr){
        if(arr==null||arr.length==0){
           throw new IllegalArgumentException("Invalid Input");
        }
        int max=arr[0];
        for(int k: arr){
            if(k>max){  //if k > max ...new max = value in k
                max=k;
            }
        }
        return max;
    }
    public static void printArray(int[]arr){
        for(int j: arr){
            System.out.print(j+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []arr={1,6,4,2,9,7};
        printArray(arr);
        int max = findMax(arr);
        System.out.println(max);
    }
}
