package Recursion;

import javax.lang.model.util.Types;
import java.util.*;

public class HotKeys {
    /**
     * Given a list of strings, assign a unique character as a hotkey.
     * 1. Hotkey of a string should be a character of the string
     * 2. All hotkeys must be unique
     *
     * Ex['front', 'back', 'left', 'right', 'fly']
     * Output [f, b, l, r, y]
     *
     * ["forward", "backward", "left", "right", "fly", "flye", "flyee"]
     * [f,b,t,l,y,e]
     */

    public static Map<Character, String> hotKeys(List<String> input){

        Map<Character, String> result = new HashMap<>();


        helper(input, 0, result);
        return result;
    }

    private static void helper(List<String> input, int index,
                               Map<Character, String> result ) {

        if (index == input.size()) {
            return;
        }
        else {
            String s = input.get(index);
            for (int i =0; i < s.length(); i++){
                char c = s.charAt(i);
               if (! result.containsKey(c)){
                   result.put(c, s);
                   helper(input, index+1, result);
                   if(result.size() == input.size())
                       break;
                   result.remove(c);
               }
            }
        }
    }

    public static void main(String args[]){
        List<String> input = new ArrayList<>();
        input.add("forward");
        input.add("left");
        input.add("fly");
        input.add("flye");
        input.add("flyee");
        input.add("flyeee");
        System.out.println(hotKeys(input));
    }
}
