package Graph.DFS;

public class MineSweeper {
    static char[][] board;

    public static char[][] updateBoard(int[] click) {


        int m = board.length;
        int n = board[0].length;

        dfsHelper(0,0);

        //if (board[click[0][board[click[1]]]]=='B')
        printBoard();

        return board;
    }

    private static char dfsHelper(int i, int j) {

        int row = i;
        int col = j;

        if (i >= board.length || j >= board[0].length|| i < 0 || j < 0)
                return '\0';

        if (board[i][j] == 'M') {
            return 'M';
        }

        if (board[i][j] =='E') {

            int mineCount = 0;
            board[i][j] = 'B';
            int[][] nbrs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

            for (int r = 0; r < nbrs.length; r++) {
                i  += nbrs[r][0];
                j += nbrs[r][1];
                char result = dfsHelper(i,  j);
                if (result == 'M')
                    mineCount++;
                i = row;
                j= col;
            }

            if (i != row)
                System.out.println("rows Check not equal");
            if (j != col)
                System.out.println("cols Check not equal");

            if (mineCount == 0)
                board[i][j] = 'B';
            else
                board[i][j] = Character.forDigit(mineCount, 10);
            return board[i][j];
        }
        return '\0';
    }

    public static void printBoard(){
        int m = board.length;
        int n = board[0].length;

        for (int i=0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String [] args) {

        char [][] board0 = new char[][]{{'E', 'M', 'E'}, {'E', 'E', 'M'},
                 {'E', 'E', 'E'}};
        char [][] board1 = new char[][]{{'E', 'M', }, {'E', 'E'}};

        char [][] board = new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};

        MineSweeper.board = board;
        updateBoard( new int[]{3,0});
        //System.out.print(updateBoard( new int[]{3,0}));
    }
}
