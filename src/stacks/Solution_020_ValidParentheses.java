/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Given a string s containing just '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * Valid means:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 */

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Solution_020_ValidParentheses {
    
    public boolean isValid(String s) {
        // Create pairs hashmap
        Map<Character, Character> pairs = new HashMap<Character, Character>();
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');

        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.empty()) return false;
                if (pairs.get(stack.peek()) != c) return false;
                stack.pop();
            }
        }
        return stack.empty();
    }
    
    public static void main(String[] args) {
        Solution_020_ValidParentheses sol = new Solution_020_ValidParentheses();
        
        // Test cases
        System.out.println("() should be true: " + sol.isValid("()"));
        System.out.println("()[]{} should be true: " + sol.isValid("()[]{}"));
        System.out.println("(] should be false: " + sol.isValid("(]"));
        System.out.println("([)] should be false: " + sol.isValid("([)]"));
        System.out.println("{[]} should be true: " + sol.isValid("{[]}"));
        System.out.println("empty should be true: " + sol.isValid(""));
        System.out.println("((( should be false: " + sol.isValid("((("));
    }
}
