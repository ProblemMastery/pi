package My_Array;

import java.util.HashSet;
import java.util.Set;

/*Given an unsorted array of integers,
find the length of the longest consecutive elements sequence.
Your algorithm should run in O(n) complexity.

 */
public class Hard_LongestConsecSequence {

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int n : nums)
            set.add(n);

        int longeastStreak = 0;
        for (int n : nums){
            if (!set.contains(n-1)){

                int currentStreak = 1;

                while (set.contains(n+1)){
                    n = n+1;
                    currentStreak += 1;

                }
                longeastStreak = Math.max(longeastStreak, currentStreak);
            }

        }
        return longeastStreak;
    }


    public static void main(String[] args) {

        int [] nums = {5,1,10,6,11,12,3,2,4};
        System.out.print(longestConsecutive(nums));

    }
}
