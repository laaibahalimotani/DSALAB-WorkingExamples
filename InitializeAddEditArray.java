public class InitializeAddEditArray {
    public static void main(String[] args) {
        //declaring and initializing
        int []arr=new int[5];
        //adding
        arr[0]=5;
        arr[1]=4;
        arr[2]=6;
        arr[3]=7;
        arr[4]=2;
        //before deleting and editing
        System.out.println("Before editing and deletion");
        for(int i: arr){
            System.out.print(i+" ");
        }
        //editing
        arr[2]=10;
        //deleting element at index 1
        for(int i=1;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        //setting the last index to zero since it contains a duplicate
        arr[arr.length-1]=0;
        //after deleting and editing
        System.out.println("\nAfter editing and deletion");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
