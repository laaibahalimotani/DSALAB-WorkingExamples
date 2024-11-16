public class MoveZeroToEnd {
    public static int[] moveZero(int[]arr){ //int n = arr.length
      int n= arr.length;;
      int j =0;
      for(int i=0;i<n;i++){ //since we're swapping we need to access indices properly hence enhanced for loop cant be used here
          if(arr[i]!=0 && arr[j]==0){
              int temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
          }
          if(arr[j]!=0){
              j++;
          }
      }
      return arr;
    }
    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int []arr ={1,6,0,2,4,0,4};
        int[] end = moveZero(arr);
        printArray(end);
    }
}
