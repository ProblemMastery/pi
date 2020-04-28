package StacksAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    // @include
    public static boolean isWellFormed(String s) {
        Deque<Character> leftChars = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                leftChars.addFirst(s.charAt(i));
            } else {
                if (leftChars.isEmpty()) {
                    return false; // Unmatched right char.
                }
                if ((s.charAt(i) == ')' && leftChars.peekFirst() != '(')
                        || (s.charAt(i) == '}' && leftChars.peekFirst() != '{')
                        || (s.charAt(i) == ']' && leftChars.peekFirst() != '[')) {
                    return false; // Mismatched chars.
                }
                leftChars.removeFirst();
            }
        }
        return leftChars.isEmpty();
    }
    // @exclude

    private static void smallTest() {
        assert(isWellFormed("()"));
        assert(isWellFormed("()[]{}"));
        assert(isWellFormed("[()[]]{}"));
        assert(isWellFormed("(()[]{()[]{}{}})"));
        assert(!isWellFormed("([)]"));
        assert(!isWellFormed("["));
        assert(!isWellFormed("(()[]{()[]{})({}})"));
    }

    public static void main(String[] args) {
        smallTest();

            System.out.println(isWellFormed("[()[]]{}"));

    }
}
