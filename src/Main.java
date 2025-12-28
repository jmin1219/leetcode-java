public class Main {
    public static void main(String[] args) {
        // Uncomment the test you want to run
        
        // testLinkedList();
        // testStack();
        testRecentCounter();
    }

    public static void testLinkedList() {
        System.out.println("=== Testing MyLinkedList ===");
        MyLinkedList list = new MyLinkedList();
        
        list.addAtHead(1);           // [1]
        list.addAtTail(3);           // [1, 3]
        list.addAtIndex(1, 2);       // [1, 2, 3]
        System.out.println("get(1): " + list.get(1));  // Expected: 2
        
        list.deleteAtIndex(1);       // [1, 3]
        System.out.println("get(1): " + list.get(1));  // Expected: 3
    }

    public static void testStack() {
        System.out.println("=== Testing MyStack ===");
        MyStack stack = new MyStack();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("pop(): " + stack.pop());   // Expected: 3
        System.out.println("peek(): " + stack.peek()); // Expected: 2
        System.out.println("size(): " + stack.size()); // Expected: 2
    }

    public static void testRecentCounter() {
        System.out.println("=== Testing RecentCounter (933) ===");
        RecentCounter counter = new RecentCounter();
        
        System.out.println("ping(1): " + counter.ping(1));       // Expected: 1
        System.out.println("ping(100): " + counter.ping(100));   // Expected: 2
        System.out.println("ping(3001): " + counter.ping(3001)); // Expected: 3
        System.out.println("ping(3002): " + counter.ping(3002)); // Expected: 3
    }
}
