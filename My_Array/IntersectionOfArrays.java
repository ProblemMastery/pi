package My_Array;

import java.util.HashSet;

public class IntersectionOfArrays {
    /*
    Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
     */

    public int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();

        for(int i: nums1)
            set1.add(i);
        for (int j: nums2)
            set2.add(j);

        //using java built in function
        set1.retainAll(set2);
        int [] result = new int [set1.size()];
        int i = 0;
        for (int s: set1){
            result[i++] = s;
        }
        return result;
    }
}
