public class Solution_141_Cycle {
  public boolean hasCycle(ListNode head) {
        // 1. Initialize fast and slow pointers, both starting at head
        ListNode slow = head;
        ListNode fast = head;
        // 2. Loop while fast and fast.next are not null
        while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;

          if (slow == fast) {
            return true;
          }
        }
        return false;

    }
}
