package StringManipulation;

import java.util.ArrayList;
import java.util.List;

public class ZigzagString {
    /*
    Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"


Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
     */
    public static String convert(String s, int numRows) {

        if (numRows == 1)
            return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
    public static String convert2(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        char[] c = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();//this is an important step to initialize it
        }
        int i = 0;
        while (i < len) {
            for (int index = 0; index < numRows && i < len; index++) {
                sb[index].append(c[i++]);// vertically down
            }

            for (int index = numRows - 2; index >= 1 && i < len; index--) {
                /**Why it should start from numRows - 2? Think of the example when numRows = 3
                 the starting point of obliquely going up is 1, which is numRows-2.*/
                sb[index].append(c[i++]);// obliquely up
            }
        }

        for (i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }


    public static void main(String[] args) {
        String s = "PAYPALISHIRINGTPMK";
        System.out.println(convert(s,6));
       // System.out.println(convert2(s,5));
    }
}
