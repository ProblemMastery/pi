package Graph.DFS;

import java.util.HashSet;
import java.util.Set;

public class FriendsCircle {
    /**
     * https://leetcode.com/problems/friend-circles
     * There are N students in a class.
     * Some of them are friends, while some are not.
     * Their friendship is transitive in nature.
     * For example, if A is a direct friend of B, and B is a direct friend of C,
     * then A is an indirect friend of C. And we defined a friend circle is a group of students
     * who are direct or indirect friends.
     *
     * Given a N*N matrix M representing the friend relationship
     * between students in the class. If M[i][j] = 1, then the ith and jth students
     * are direct friends with each other, otherwise not.
     * And you have to output the total number of friend circles among all the students.
     *
     * Example 1:
     * Input:
     * [[1,1,0],
     *  [1,1,0],
     *  [0,0,1]]
     * Output: 2
     * @param M
     * @return
     */

        public int findCircleNum(int[][] M) {

            Set<Integer> set = new HashSet<>();
            int N = M.length;
            int cc = 0;
            for (int i = 0 ; i < N; i ++){
                if (!set.contains(i)){

                    dfsHelper(M, i, set);
                    cc++;
                }
            }
            return cc;
        }

        private void dfsHelper(int[][]M, int i, Set<Integer> set){

            set.add(i);
            for (int j = 0 ; j < M.length; j++){
                if ( i != j && !set.contains(j) && M[i][j] == 1)
                    dfsHelper(M, j, set);
            }
        }

}
