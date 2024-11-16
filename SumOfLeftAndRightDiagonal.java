public class SumOfLeftAndRightDiagonal {
    public static void main(String[] args) {
        //square matrix has the same number of rows and columns
        int[][] squareMatrix= new int[3][3];
        for(int i=0;i<squareMatrix.length;i++){
            for(int j=0;j<squareMatrix[i].length;j++){
                squareMatrix[i][j]=(int)(Math.random()*10);
            }
        }
        printMatrix(squareMatrix);
        leftDiagonalSum(squareMatrix);
        rightDiagonalSum(squareMatrix);
    }
    public static void leftDiagonalSum(int [][]matrix){
        int sum = 0;
        //the row and column indices in a left diagonal of a square matrix are same
        for(int i=0;i<matrix.length;i++){
            sum += matrix[i][i];
            }
        System.out.println("left diagonal sum: "+sum);
        }


    public static void rightDiagonalSum(int [][]matrix){
        int n= matrix.length;
        int sum=0;
        //for a right diagonal in a matrix row indices are [i] and column indices are [n-1-i] where n= the length of the square index
        for(int i=0; i<n;i++){
            sum+=matrix[i][n-1-i];
        }
        System.out.println("right diagonal sum: "+sum);
    }
    public static void printMatrix(int[][] matrix){
        for(int []n:matrix){
            for(int m:  n){
                System.out.print(m+" ");
            }
            System.out.println();
        }
    }
}
