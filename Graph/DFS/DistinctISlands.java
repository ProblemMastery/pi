package Graph.DFS;

import Graph.Graph;

import java.util.*;

public class DistinctISlands {
    private static ArrayList<Integer> shape;

        public static int numDistinctIslands(char[][] grid) {

            int rows = grid.length-1;
            int cols =  grid[0].length-1;

            Set<ArrayList> distinctIslands = new HashSet<>();

            for (int i = 0 ; i <= rows ; i++){
                for (int j = 0 ; j <= cols; j++){
                    if(grid[i][j] == '1'){
                        shape = new ArrayList<>();
                        dfsHelper(grid, i , j, 0);
                        if (!shape.isEmpty())
                            distinctIslands.add(shape);
                    }
                }
            }
            return distinctIslands.size();
        }

        private static void dfsHelper(char[][] grid, int i, int j, int distinctId) {

            int row = grid.length;
            int col = grid[0].length;

            if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j]=='0'){
                return;
            }

                    //mark the cell
                grid[i][j] = '0';
                //add the offset to list
                shape.add(distinctId);
                dfsHelper(grid, i + 1, j, 1);
                dfsHelper(grid, i - 1, j, 2);
                dfsHelper(grid, i, j + 1, 3);
                dfsHelper(grid, i, j - 1, 4);
                shape.add(0);


        }
        public static void main(String [] args) {
            char [][] board = new char[][]{{'1', '0', '0', '0'}, {'1', '0', '0', '0'},
                    {'0', '0', '0', '1'}, {'0', '0', '0', '1'}};

            System.out.print(numDistinctIslands(board));
        }
    }

