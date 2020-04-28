package StringManipulation;

import java.util.HashSet;
import java.util.Set;

public class Palindrome {

    /*
    EPI : 12.1 : test if a string can be permute to be a palindrome
     */

    public static boolean canFormPalindrome(String s){
        Set<Character> characterSet = new HashSet<>();

        for(Character c : s.toCharArray()){

            if(characterSet.contains(c))
                characterSet.remove(c);
            else
                characterSet.add(c);
        }
        return characterSet.size()<=1;
    }
}
