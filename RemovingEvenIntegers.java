public class RemovingEvenIntegers {
   static int[] removeEven(int[] arr){
        int n=arr.length;
        int oddCount=0;
        for (int k : arr) {
            if (k % 2 != 0) {
                oddCount++;  // finding the index for the new array
            }
        }
        int[] result=new int[oddCount]; //resultant array size = no.of odd numbers in initial array
        int idx=0;
        for (int j : arr) {
            if (j % 2 != 0) {
                result[idx] = j;     //assigning odd values in the arr array to the result arr at index (idx)starting from 0
                idx++;
            }
        }
        return result;

    }
    public static void printArray(int[]arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int []arr= {1,3,4,5,6,2,7,9,8};
        int []result= removeEven(arr);
        printArray(arr);
        printArray(result);
    }
}
