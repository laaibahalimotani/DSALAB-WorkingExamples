public class SearchInsertDeleteSortedArray {
    //binary search
    public static int searchSorted(int[] arr, int low, int high, int key){ //low= lowest index, high= highest index, key= no. searched
        if(high<low){
            return -1;
        }
        int mid= (low+high)/2; // find the mid of array
        if(arr[mid]==key){
            return mid; //key found at mid
        }if(key<arr[mid]){ //if key<arr[mid] search in left half
            return searchSorted(arr,low,(mid-1),key); //recursively searching left
        }
        //if key>arr[mid] search in right half
        return searchSorted(arr,(mid+1),high,key); //recursively searching right
    }
    public static int insertSorted(int[] arr,int n, int key,int capacity){ //n= no.of elements in array currently
        if(n>=capacity){ //capacity is length of array
            System.out.println("Array is full. Cannot insert");
            return n; //if insertion not possible return current size
        }
        int i;
        for( i= n-1;(i>=0 && arr[i]>key);i--){
            arr[i+1]=arr[i];  //moving elements to right side
        }
        arr[i+1]=key; //inserting
        return n+1; //return new size of array

    }
    public static int deleteSorted(int[] arr, int key,int n){
        int pos = searchSorted(arr,0,n-1,key);
        if(pos==-1){
            System.out.println("Element not found. Cannot delete");
            return n; //returning current size if deletion not possible
        }
        int i;
        for(i=pos;i<n-1;i++){ //starting from the position of the element that needs to be deleted
            arr[i]=arr[i+1]; //moving elements to the left
        }

        return n-1;// returning new size of the array after deletion
    }
    //print array elements up to given size
    public static void printArray(int[] arr, int size){
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] testArray = {1,2,4,5,7,9,0,0}; //extra spaces for insertion
        int n = 6; //initial no.of elements in the array

        //search
        int search = searchSorted(testArray,0,n-1,9);
        System.out.println("Element searched is at index: "+search);

        //insert
        n= insertSorted(testArray,n,6,testArray.length);
        System.out.println("Array after insertion: ");
        printArray(testArray,n);

        //delete
        n= deleteSorted(testArray,7,n);
        System.out.println("Array after deletion: ");
        printArray(testArray,n);
    }
}
