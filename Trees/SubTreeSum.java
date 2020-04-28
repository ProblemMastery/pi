package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubTreeSum {

    /*
    https://leetcode.com/problems/most-frequent-subtree-sum/
    Given the root of a tree, you are asked to find the most frequent subtree sum.
    The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
     So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
     */
    /*
      5
    /  \
    2   -3  return [2, -3, 4], since all the values happen only once, return all of them in any order.
     */

    int maxCount = 0 ;
    Map<Integer, Integer> subtreeSumToCountMap = new HashMap<>();
    public List<Integer> findFrequentTreeSum (TreeNode root) {

        List<Integer> result = new ArrayList<>();
        helper(root);
        for (int sum : subtreeSumToCountMap.keySet()){
            if (subtreeSumToCountMap.get(sum) == maxCount){
                result.add(sum);
            }
        }
        return result;
    }

    private int helper(TreeNode root) {

        if (root == null)
            return 0;
        int sum = helper(root.left) + helper(root.right) + root.key;
        subtreeSumToCountMap.put(sum, subtreeSumToCountMap.getOrDefault(sum, 0)+1);

        maxCount = Math.max(maxCount, subtreeSumToCountMap.get(sum) );
        return sum;
    }
}
