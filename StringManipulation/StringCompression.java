package StringManipulation;

/*
https://leetcode.com/problems/string-compression/ - 443
Given an array of characters, compress it in-place.
The length after compression must always be smaller than or equal to the original array.
Every element of the array should be a character (not int) of length 1.
After you are done modifying the input array in-place, return the new length of the array.

Follow up:
Could you solve it using only O(1) extra space?
 */
public class StringCompression {

    public static int compress(char[] chars) {

        if( chars.length == 0){
            return 0;
        }
        if( chars.length == 1){
            return 1;
        }
        int result = 0;
        int i = 0 ;
        int j = i+1;
        int count = 1;
        while(j < chars.length){
            if(chars[i] == chars[j]){
                j++;
                count++;
            }
            else {
               if(count == 1)
                   result += 1;
               else if(count <10)
                   result +=2;
               else  if(count>10)
                   result +=3;
               i = j;
               j = i+1;
               count=1;
            }
        }
        return  result;
    }
    public static void main(String[] argv) {

        String s = "aabbccc";
        System.out.print(compress(s.toCharArray()));
    }
}
