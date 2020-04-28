package TwoPointer;

public class BackspaceStringCompare {
    /*
    https://leetcode.com/problems/backspace-string-compare/
     */

    public boolean backspaceCompare(String S, String T) {

        int i = S.length()-1;
        int j = T.length()-1;

        while(i >= 0 || j >= 0 ){

            i = getValidIndex(S, i);
            j = getValidIndex(T, j);

            if (i < 0 && j < 0)
                return true;

            if (i < 0 || j < 0)
                return false;

            if(S.charAt(i) != T.charAt(j))
                return false;

            i--;
            j--;
        }
        return true;
    }

    private int getValidIndex(String s, int i) {

        int backspace = 0;
        while (i >=0){

            if (s.charAt(i)== '#')
                backspace++;
            else if (backspace > 0)
                backspace--; // one less backspace to count
            else
                break;
            i--;
        }
        return i;
    }
}
