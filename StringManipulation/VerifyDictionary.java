package StringManipulation;

public class VerifyDictionary {

    public static boolean verify2Words(String word1, String word2){

        int m = word1.length();
        int n = word2.length();

        int length = Math.min (m, n);
        for (int j = 0; j < length; j++)
            if (word1.charAt(j) != word2.charAt(j))
                if (word1.charAt(j) - 'a' > word2.charAt(j) - 'a')
                    return false;
                else
                    length = -1;
        if (length != -1 && m > n)
            return false;

        return true;
    }

    public static boolean isSorted(String[] words) {
        int[] index = new int[26];

        for (int i = 0; i < words.length - 1; i++) {
           if(! verify2Words(words[i], words[i+1]))
               return false;
        }
        return true;
    }
    public static void main(String [] args){
       System.out.println( verify2Words("ap", "aap"));
        System.out.println( isSorted(new String[]{"ap", "apple", "ball", "cat", "eel", "dog"}));
    }
}
