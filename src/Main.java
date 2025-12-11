public class Main {
    public static void main(String[] args) {
        // 1. Instantiate Nodes (equivalent to node = ListNode(1))
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(99);

        // 2. Link them (Pointer manipulation)
        head.next = second; // 1 -> 2
        second.next = third; // 2 -> 3
        third.next = fourth;

        // 3. Traverse and Print (The 'while' loop is very similar to Python)
        System.out.println("--- Traversal Start ---");
        ListNode current = head; // Start at the head
        
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next; // Move the pointer
        }
        System.out.println("null");
        System.out.println("--- Traversal End ---");
    }
}