public class TransposeOf2DArray {
    public static void main(String[] args) {
        int [][]originalMatrix = new int[3][4];
        //generating random numbers from 0-9 to fill the matrix
        for(int i=0;i<originalMatrix.length;i++){
            for(int j=0;j<originalMatrix[i].length;j++){
                originalMatrix[i][j]= (int)(Math.random()*10);
            }
        }
        System.out.println("Original Matrix: ");
        printMatrix(originalMatrix);
        //creating a new matrix to store the transposed matrix
        int [][] transposedMatrix = new int[4][3];
        for(int i = 0; i< transposedMatrix.length; i++){
            for(int j = 0; j< transposedMatrix[i].length; j++){
                transposedMatrix[i][j]=originalMatrix[j][i]; //transposing the original matrix
            }
        }
        System.out.println("Transpose of original: ");
        printMatrix(transposedMatrix);
        }
        //method to print matrix
        public static void printMatrix(int[][] matrix){
            for(int []n:matrix){
                for(int m:n){
                    System.out.print(m+" ");
                }
                System.out.println();
            }
        }
    }

