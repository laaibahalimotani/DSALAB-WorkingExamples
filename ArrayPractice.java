import java.util.Arrays;
public class ArrayPractice {
   public static int maxSubArraySum(int []arr){ //kadane's algo
        int sum = 0;
        int max =Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
    public static void returnPairWithSumK(int[]arr,int sum){
       Arrays.sort(arr);
       int low=0;
       int high= arr.length-1;
       while(low<high){
           if(arr[low]+arr[high]>sum){
               high--;
           }else if(arr[low]+arr[high]<sum){
               low++;
           }else if(arr[low]+arr[high]==sum){
               System.out.println("Pairs: ["+arr[low]+", "+arr[high]+"]");
               low++;
               high--;
           }
       }
    }
    public static int[] sort0s1s2s(int []arr) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == 0)
                zeroCount++;
            if (arr[i] == 1)
                oneCount++;
        }
        for (int i = 0; i < zeroCount; i++) {
            arr[i] = 0;
        }
        for (int i = zeroCount; i < (zeroCount + oneCount); i++) {
            arr[i] = 1;
        }
        for (int i = (zeroCount + oneCount); i < arr.length; i++) {
            arr[i] = 2;
        }
        return arr;
    }
    public static void rotateRight(int []arr, int k){
       int length= arr.length;
       k = k % length; //if k>length -> this step ensures we rotate the array only by k steps to the right
       reverse(0,length-k-1,arr); //rotating first half
       reverse(length-k,length-1,arr);//rotating second half
       reverse(0,length-1,arr);// rotating the entire array
    }
    public static void reverse(int start, int end, int []arr){
       while(start<end){
           int temp = arr[start];
           arr[start]=arr[end];
           arr[end]=temp;
           start++;
           end--;
       }
    }
    public static void rotateLeft(int[]arr, int k){
       int length=arr.length;
       k = k % length;
       reverse(0,k-1,arr); //reversing the first elements till k
       reverse(k,length-1,arr); //reversing rest of the elements
       reverse(0,length-1,arr); //reversing the entire array
    }

    public static void main(String[] args) {
        int []arr = {1,2,3,8,9,10};
        rotateRight(arr,2);
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
        int []arr1={1,2,3,8,9,10};
        rotateLeft(arr1,2);
        for(int i: arr1){
            System.out.print(i+" ");
        }

    }
}

