package StringManipulation;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class StringManipulationProblems {
    /*
    This class contains String Manipulation Problems.
    1. String to int
    2. Integer to String
    3. Base Conversion.
    4. Palindromicity
    5. Reverse all words in a sentence

     */


    public static String intToString(int x){
        boolean isNegative =  (x<0 ? true : false);

        StringBuilder result = new StringBuilder();
        do{
            //extract the last digit using modulo and append using +'0'
            result.append((char)('0'+ Math.abs(x%10)));
            //remove the last digit from the number using /
            x /= 10;
        }while(x !=0);

        if (isNegative){
            result.append("-");

        }
        result.reverse();
        return result.toString();
    }
    public static int StringToInt(String s){
        int result=0;
        //traverse thru each char
        //if the first char is "-" symbol denoting a negative sign, start from next char
        for(int i = (s.charAt(0)== '-'? 1:0); i< s.length(); ++i){
            int digit = s.charAt(i)-'0';
            result = result*10 + digit;
        }
        return s.charAt(0) == '-' ? -result : result;

    }
    public static boolean isPalindrome(String s){

        int i=0;
        int j = s.length()-1;
        while(i < j){

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static int RomanToDecimal(String num){

        Hashtable<Character, Integer> romanToDecimalMap = new Hashtable<Character, Integer>() {
            {
                put('I', 1);

                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
            // sum is the value of last character
            int sum = romanToDecimalMap.get(num.charAt(num.length()-1));
            for(int i =num.length()-2; i>=0; i--){
                //eg : XI => 11
                if(romanToDecimalMap.get(num.charAt(i)) < romanToDecimalMap.get(num.charAt(i+1))){
                    sum = sum+ romanToDecimalMap.get(num.charAt(i));
                }else {
                    sum = sum - romanToDecimalMap.get(num.charAt(i));
                }
            }
        return sum;
    }

    public static void tests(){

        //System.out.println("String to int 7980 "+ StringToInt("-7980"));

        System.out.println("int 7897 in string is "+intToString(7897));
        //System.out.println("Madam is palindrome ? "+isPalindrome("Madam"));
        //System.out.println("y7u7y is Palindrome  ? "+isPalindrome("y7u7y"));

        Set<Integer> set = new HashSet<>();




    }
}
