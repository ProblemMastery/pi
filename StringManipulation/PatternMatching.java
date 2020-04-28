package StringManipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {

    public static boolean isPatternMatched(String input, String pattern ){
        Pattern pat = Pattern.compile(pattern);
        Matcher m = pat.matcher(input);
        return m.find();
    }

    public static String getDataWithinQuotes(String input){
        Pattern pattern = Pattern.compile("'(.*?)'");
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()) {
            System.out.println("--->" + matcher.group(1));
        }
        return matcher.group(1);
    }

//    public static String replaceWithMarkup (String input){
//        // This is a sample line ~~ Strike ~~ with
//        //This is a sample line <del> Strike </ del>
//        Pattern pattern = Pattern.compile("'(.*?)'");
//        Matcher matcher = pattern.matcher(input);
//        if(matcher.matches()) {
//            System.out.println("--->"+matcher.group(1));
//            input.replaceAll(matcher.group(1), "");
//        }
//        return  matcher.group(1);
//    }

    public static void testGetDataWithQuotes(){
        System.out.println(getDataWithinQuotes("some string with 'the data i want' inside"));
    }
//    public static void testreplaceWithMarkup(){
//        System.out.println(replaceWithMarkup("The art of 'living'"));
//    }

    public static void testPatternMatch(){
        //false on case sensitive
        System.out.println(isPatternMatched("beingYou", "you"));
        System.out.println(isPatternMatched("beingYou", "being"));
        //true with wildcard matching
        System.out.println(isPatternMatched("beingYou", "be*"));
        //matches with regex ^ beginning of word
        System.out.println(isPatternMatched("beingYou", "^be"));
        //matches, Setcdefinition, can match the letter i or k or z.
        System.out.println(isPatternMatched("tiktok1234", "[ikz]"));
        //When a caret appears as the first character inside square brackets, it negates the pattern.
        // This pattern matches any character except a or b or c.
        System.out.println(isPatternMatched("abc1234", "[^abc]"));
        //matches the range in the braces []
        System.out.println(isPatternMatched("mnopq1234", "[m-p]"));
        System.out.println(isPatternMatched("Its important to feel grateful", "\\w"));
        //true - A word character, short for [a-zA-Z_0-9]
        System.out.println(isPatternMatched("123456789", "\\w"));
        //Matches a word boundary where a word character is [a-zA-Z0-9_]
        System.out.println(isPatternMatched("123456789", "\\b"));
        //returns true if the string does not have a number at the beginning
        System.out.println(isPatternMatched("123456789", " ^[^\\d].*"));
        System.out.println(isPatternMatched("the end","[a-zA-Z]{3}"));

    }
    public static void main(String [] args){

        testGetDataWithQuotes();
    }
}
