public class ReversingArray {
    public static int[] reverseArray(int []arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return arr;
    }
    public static void printArray(int[]arr){
        for(int j: arr){
            System.out.print(j+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int []arr={1,3,11,4,2,5};
        printArray(arr);
        int []reversed=reverseArray(arr,0, arr.length-1);
        printArray(reversed);
    }
}
