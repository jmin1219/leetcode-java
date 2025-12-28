import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * 
 * Implement a FIFO queue using only two stacks. The queue should support:
 * - push(x): Push element x to the back of queue.
 * - pop(): Remove the element from the front of queue and return it.
 * - peek(): Return the front element.
 * - empty(): Return true if the queue is empty.
 * 
 * You may only use standard stack operations:
 * - push to top, peek/pop from top, size, and isEmpty.
 * 
 * Example:
 * MyQueue queue = new MyQueue();
 * queue.push(1);  // queue: [1]
 * queue.push(2);  // queue: [1, 2]
 * queue.peek();   // returns 1
 * queue.pop();    // returns 1, queue: [2]
 * queue.empty();  // returns false
 */
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if (!stack2.isEmpty()) return stack2.pop();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    
    public int peek() {
        if (!stack2.isEmpty()) return stack2.peek();
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        
        queue.push(1);
        queue.push(2);
        System.out.println("peek(): " + queue.peek());   // Expected: 1
        System.out.println("pop(): " + queue.pop());     // Expected: 1
        System.out.println("empty(): " + queue.empty()); // Expected: false
        System.out.println("pop(): " + queue.pop());     // Expected: 2
        System.out.println("empty(): " + queue.empty()); // Expected: true
    }
}
