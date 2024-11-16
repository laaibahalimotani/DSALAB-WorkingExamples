public class FindingMinimum {
    public static int findMin(int []arr){
        if(arr==null||arr.length==0){    //if the array is empty the code will exit here
            throw new IllegalArgumentException("Invalid Input");
        }
        int min = arr[0];
        for(int i: arr){ //if using a normal for loop - starting from index 1 and comparing each element to the value at index 0 that is stored in min
            if(i<min){
                min=i;
            }
        }
        return min;
    }
    public static void printArray(int[]arr){
        for(int j: arr){
            System.out.print(j+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int []arr={5,6,9,2,4};
        printArray(arr);
        int min = findMin(arr);
        System.out.println(min);
    }
}
