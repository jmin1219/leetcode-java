/**
 * Stack implementation from scratch
 * 
 * Operations:
 * - push(x): add element to top
 * - pop(): remove and return top element
 * - peek(): return top element without removing
 * - isEmpty(): check if stack is empty
 * 
 * All operations should be O(1)
 */

import java.util.ArrayList;

public class MyStack {
    
    // Your internal storage here (array or ArrayList)
    private ArrayList<Integer> arr;
    
    public MyStack() {
        // Initialize your storage
      arr = new ArrayList<>();
    }
    
    public void push(int x) {
        // Add x to top of stack
        arr.add(x);
    }
    
    public int pop() {
        // Remove and return top element
        if (!arr.isEmpty()) {
          return arr.remove(arr.size() - 1);
        }
        // What should happen if stack is empty?
        throw new RuntimeException("Stack is empty"); 
    }
    
    public int peek() {
        // Return top element without removing
        if (!arr.isEmpty()) {
          return arr.get(arr.size() - 1);
        }
        throw new RuntimeException("Stack is empty"); 
    }
    
    public boolean isEmpty() {
        return arr.size() == 0;
    }
    
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        
        // Test cases
        System.out.println("isEmpty (should be true): " + stack.isEmpty());
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("peek (should be 3): " + stack.peek());
        System.out.println("pop (should be 3): " + stack.pop());
        System.out.println("pop (should be 2): " + stack.pop());
        System.out.println("isEmpty (should be false): " + stack.isEmpty());
        System.out.println("pop (should be 1): " + stack.pop());
        System.out.println("isEmpty (should be true): " + stack.isEmpty());
    }
}
