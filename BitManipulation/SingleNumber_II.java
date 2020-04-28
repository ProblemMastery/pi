package BitManipulation;


/* Given a non-empty array of integers,
    every element appears three times except for one, which appears exactly once.
    Find that single one.

    Input: [2,2,3,2]
    Output: 3

    Input: [0,1,0,1,0,1,99]
    Output: 99
     */
public class SingleNumber_II {

    public static int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

    public static void main(String[] args) {
        int [] nums = {4,4,4,5};
        System.out.print(singleNumber(nums));
    }
}
