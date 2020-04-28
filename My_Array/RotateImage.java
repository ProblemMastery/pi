package My_Array;
/*
https://leetcode.com/problems/rotate-image/
Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]

  Solution :After running few examples, the first step is to transpose the matrix,
  i.e move rows to cols and cols to rows/
 */
public class RotateImage {

    public static int [][] rotateImage(int[][] image){

        if(image.length != image[0].length)
            return image;

        int N = image.length;

        //transpose
        for(int i = 0 ; i < N ; i ++){
            for(int j = i ; j < N ; j++){
                int temp = image[i][j];
                image[i][j] = image[j][i];
                image[j][i] = temp;
            }
        }
        int [][] transposed = image;
        // exch cols
        for (int i = 0 ; i <N ; i++){
            for(int j =0 ; j < N/2 ; j++ ){
                int temp = image[i][j];
                image[i][j] = image[i][N-1-j];
                image[i][N-1-j] = temp;
            }
        }
        return image;
    }
    public static void printArray(int[][] arr){

        for(int i = 0 ; i <arr.length; i++){
            for(int j = 0 ; j <arr[0].length; j++){
                System.out.print(arr[i][j]+",");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        int [][] image  = {{1,2,3},{4,5,6},{7,8,9}};

        printArray(image);
        System.out.println("After rotation :");
        printArray(rotateImage(image));
    }

}
