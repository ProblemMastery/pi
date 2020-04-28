package Math;
/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
 */
public class ReverseNum {


    public int reverseNum(int num){
        boolean isNegative = false;
        if(num < 0 ){
            num = Math.abs(num);
            isNegative = true;
        }

        int reverse = 0 ;
        while (num > 0){
            int pop = num%10;
            reverse = reverse*10 + pop;
            num = num /10;
        }

        if(isNegative){
            return -reverse;
        }
        return  reverse;
    }


}
