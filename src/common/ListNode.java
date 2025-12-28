public class ListNode {
  // 1. Member Variables (Data)
  // Must declare their visibility (public) and type (int, ListNode).
  int val;
  ListNode next;

  // 2. Constructors (like "def __init__" in Python)
  // Java allows "Overloading" - multiple constructors with different arguments.

  // Option A: Just a value (next is null by default)
  ListNode(int x) {
    val = x;
    next = null;  // Explicitly stating null is good practice
  }

  // Option B: Value + Next Node
  ListNode(int val, ListNode next) {
    this.val = val;  // 'this' disambiguates the member var from the argument
    this.next = next;
  }
}
