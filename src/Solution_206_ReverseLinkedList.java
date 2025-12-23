/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * Given the head of a singly linked list, reverse the list, 
 * and return the reversed list.
 * 
 * Example 1: 1 -> 2 -> 3 -> 4 -> 5  becomes  5 -> 4 -> 3 -> 2 -> 1
 * Example 2: 1 -> 2  becomes  2 -> 1
 * Example 3: []  becomes  []
 */
public class Solution_206_ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    // Your solution here
    if (head == null) {
      return head;
    }
    
    ListNode curr = head;
    ListNode temp = null;
    ListNode nxt;
    while (curr != null) {
      nxt = curr.next;
      curr.next = temp;
      temp = curr;
      curr = nxt;
    }

    return temp;
  }

  // Optional: recursive approach
  public ListNode reverseListRecursive(ListNode head) {
    // Your solution here
    if (head == null || head.next == null) {
      return head;
    }

    ListNode newHead = reverseListRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  public static void main(String[] args) {
    Solution_206_ReverseLinkedList sol = new Solution_206_ReverseLinkedList();
    
    // Test case 1: 1 -> 2 -> 3 -> 4 -> 5
    ListNode head = new ListNode(1, 
                      new ListNode(2, 
                        new ListNode(3, 
                          new ListNode(4, 
                            new ListNode(5)))));
    
    ListNode reversed = sol.reverseList(head);
    
    // Print result
    System.out.print("Reversed: ");
    while (reversed != null) {
      System.out.print(reversed.val + " -> ");
      reversed = reversed.next;
    }
    System.out.println("null");
  }
}
