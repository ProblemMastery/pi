package My_Array;

public class GameOfLife {
    private static int[][] board;
    private static int M, N;

    /*
    rules
    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population..
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     */


    public GameOfLife(int [][] board){

        this.board = board;
        this.M = board.length;
        this. N = board[0].length;
    }

    public  static int getNeighborSum(int row, int col) {
        int sum = 0 ;
        int [] neighbors = {0, -1, 1};

        for(int i = 0 ; i < neighbors.length; i++) {
            for (int j = 0; j < neighbors.length; j++) {

                // i.e not the same row and col
                if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                    int r = (row + neighbors[i]);
                    int c = (col + neighbors[j]);

                    if (r < M && r >= 0 && c < N && c >= 0) {
                        sum += board[r][c];
                    }

                }
            }
        }
        return sum;


    }

    //Rule 1 :Any live cell with fewer than two live neighbors dies, as if caused by under-population.

    public static boolean isRule1True(int row, int col){

        if(getNeighborSum(row, col)<2){
            return true;
        }else
            return false;
    }

    // Any live cell with two or three live neighbors lives on to the next generation.
    public static boolean isRule2True(int row, int col){
        if (getNeighborSum(row, col)>=2 && getNeighborSum(row, col)<=3)
            return true;
        else
            return false;
    }

    //Any live cell with more than three live neighbors dies, as if by over-population..
    public boolean isRule3True(int row, int col){
        if(getNeighborSum(row, col)>3)
            return true;
        else
            return false;
    }

    //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    public boolean isRule4True(int row, int col){

        if(getNeighborSum(row, col)==3){
            return true;
        }else
            return false;
    }

    public int [][] getNextState(int [][] board){

        int rows = board.length;
        int cols = board[0].length;
        int [][] result = new int[rows][cols];
        for(int i = 0; i <rows; i++){
            for(int j =0 ; j <cols; j++){
                if(board[i][j]==1){
                    //test rule1,2,3
                    if(isRule3True(i, j)|| isRule1True(i,j)){
                        result[i][j] = 0;
                    }
                    if(isRule2True(i,j)){
                        result[i][j] = 1;
                    }
                }else{
                    if(isRule4True(i,j)){
                        result[i][j] = 1;
                    }
                }
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        return  result;
    }

    public static void main(String [] args){
        int [][] board = new int[][]{{0, 0, 0}, {1, 1, 1}, {1, 1, 1}};
        int rows = board.length;
        int cols = board[0].length;
        GameOfLife g = new GameOfLife(board);

        int [][] result = g.getNextState(board);

        for(int i = 0; i <rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(result[i][j]);
            }
        }


    }




}
