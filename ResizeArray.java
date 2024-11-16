public class ResizeArray {
    public static int[] resize(int[] arr,int capacity){
        int []temp= new int[capacity]; // creating  anew temporary array with the new size entered by user
        for (int i=0;i<arr.length;i++){
            temp[i]=arr[i]; //copying values of initial array to temporary array
        }
        arr=temp; //assigning the new resized array to our initial/original array
        return arr;
    }
    public static void printArray(int[]arr){
        for (int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int []arr={1,4,5,3};
        int []resized = resize(arr,8);
        printArray(arr);
        printArray(resized);
    }
}
