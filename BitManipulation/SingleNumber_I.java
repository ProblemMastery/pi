package BitManipulation;


/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Input: [4,1,2,1,2]
Output: 4

If we take XOR of zero and some bit, it will return that bit
 a⊕0=a
If we take XOR of two same bits, it will return 0
 a⊕a=0
 a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
 */
public class SingleNumber_I {


    public int singleNumber(int [] nums){
        int a = 0 ;

        for ( int n : nums ){
            a ^= n;
        }
        return a;
    }
}
