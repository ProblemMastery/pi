package Graph.DFS;

import java.util.*;

public class Cruise {


    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */


/*
  Given m lines, each line have n numbers, if you choose one from each line and add them up, you could have n^m different ways. Please give the largest n results of these results. The output need to also in descending order.
  Examples:
  m = 2, n = 3
  5 8 7
  8 9 5
  1 2 3
   stack <0> <5,8 , 15, 16, 13,14,15>
  Result:
  [17, 16, 16]  [13, 14, 10, 16
  Hint: 17 = 8 + 9, 16 = 7 + 9, 16 = 8 + 8
*/



        public static List<Integer> getLargestNNum(int[][] mat) {

            int m = mat.length;
            int n = mat[0].length;

            PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
            minHeap.add(0);
            List<Integer> result = new ArrayList<>();
            Stack<Integer> stack = new Stack<Integer>();

            for (int i = 0 ; i < n; i++)
                stack.push(mat[0][i]);

            while (!stack.isEmpty()) {

                int top = stack.pop();
                for (int i = 1; i < m; i++) {
                    System.out.println("top is " + top);
                    for (int j = 0; j < n; j++) {
                        int val = top + mat[i][j];
                        System.out.println("pushing  " + val);
                        stack.push(val);
                    }
                }

                    int k = 0;
                    while (k < n) {
                        int num = stack.pop();
                        System.out.println("num is "+num);
                        if (num >= minHeap.peek()) {

                            minHeap.add(num);
                            if (minHeap.size() > n)
                                minHeap.poll();
                        } //' if minHeap
                        k++;
                    }// while k

                }// while stack


                Iterator<Integer> itr = minHeap.iterator();
                while (itr.hasNext()) {

                    result.add(0, itr.next());
                }

                return result;
        }

            public static void main(String[] args) {
                int [][] arr = new int[][]{{5 ,8 ,7},{8, 9, 5}};
            System.out.println(getLargestNNum(arr));

            }
    }
