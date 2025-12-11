public class Solution_142_CycleII {
  public ListNode detectCycle(ListNode head) {
        // 1. Detect if cycle exists, find meeting point
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;

          if (slow == fast) {
            ListNode curr1 = head;
            ListNode curr2 = slow;
            while (curr1 != curr2) {
              curr1 = curr1.next;
              curr2 = curr2.next;
            }
            return curr1;
          }
        }

        return null;
    }
}
