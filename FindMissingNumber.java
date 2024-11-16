public class FindMissingNumber {
    public static int missingNumber(int[]arr){
        int n= arr.length+1; //(using arr.length+1) because the size of the array is missing that one element hence for the sum of natural numbers we need to add 1 to the length
        int sum = (n * (n + 1)) / 2;
        for (int j:arr) {
            sum-=j;
        }
        return sum;
    }

    public static void main(String[] args) {
        int []arr={1,5,4,3,6,7,9,8};
        int missing = (missingNumber(arr));
        System.out.println(missing);
    }
}
