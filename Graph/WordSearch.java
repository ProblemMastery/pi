package Graph;

public class WordSearch {

    static char[][]board;

    public WordSearch(char[][] board){
        this.board = board;
    }

    public static boolean exist(String word){

        int k = 0;

        for (int i = 0 ; i < board.length; ++i){
            for (int j = 0 ; j <board[0].length; ++j){

                if(board[i][j] == word.charAt(k)){
                    if(dfsSearch(i, j, k, word))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsSearch(int i, int j, int k, String word) {

        if(k == word.length())
            return true;

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j]=='0'
        || board[i][j] != word.charAt(k)){
            return false;
        }
         //else when everything is right

            //mark i,j as visited, but before that store it in a temporary array
        char temp = board[i][j];
        board[i][j] = '0';
        boolean searchFound = dfsSearch(i + 1, j, k + 1, word) ||
                    dfsSearch(i, j + 1, k + 1, word) ||
                    dfsSearch(i, j + 1, k + 1, word) ||
                    dfsSearch(i - 1, j, k + 1, word) ||
                    dfsSearch(i, j - 1, k + 1, word) ;
            //if searchFound end up being false , then re-assign the old value, unmark it
        board[i][j] = temp;
        return searchFound;

    }
    public static void main(String [] args) {
        char [][] board = new char[][]{{'a', 'b', 'c'}, {'e', 'f', 'd'}, {'i', 'j', 'k'}};
        WordSearch w = new WordSearch(board);

        System.out.print(exist("bcdk"));
    }
}
