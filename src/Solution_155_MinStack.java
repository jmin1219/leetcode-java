/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 * 
 * Design a stack that supports push, pop, top, and retrieving 
 * the minimum element in constant time.
 * 
 * Implement the MinStack class:
 * - MinStack() initializes the stack object
 * - void push(int val) pushes the element val onto the stack
 * - void pop() removes the element on the top of the stack
 * - int top() gets the top element of the stack
 * - int getMin() retrieves the minimum element in the stack
 * 
 * All operations must be O(1).
 */

import java.util.Stack;

public class Solution_155_MinStack {
    private Stack<Integer> values;
    private Stack<Integer> mins;

    public Solution_155_MinStack() {
        // Initialize your data structures
        values = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
        values.add(val);
        if (mins.empty() || val <= mins.peek()) {
            mins.add(val);
        }
    }
    
    public void pop() {
        Integer val = values.pop();
        if (val.equals(mins.peek())) mins.pop();
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
    
    public static void main(String[] args) {
        Solution_155_MinStack minStack = new Solution_155_MinStack();
        
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin (should be -3): " + minStack.getMin());
        minStack.pop();
        System.out.println("top (should be 0): " + minStack.top());
        System.out.println("getMin (should be -2): " + minStack.getMin());
    }
}
