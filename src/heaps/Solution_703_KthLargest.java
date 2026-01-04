package heaps;

import java.util.PriorityQueue;

public class Solution_703_KthLargest {
  private PriorityQueue<Integer> pq;
  private int k;

  public Solution_703_KthLargest(int k, int[] nums) {
    this.k = k;
    this.pq = new PriorityQueue<>();
    
    for (int i = 0; i < nums.length; i++) {
      if (pq.size() == k && nums[i] < pq.peek()) continue;

      pq.offer(nums[i]);
      if (pq.size() > k) pq.poll();
    }
  }

  public int add(int val) {
    if (pq.size() < k || val > pq.peek()) {
      pq.offer(val);
      if (pq.size() > k) pq.poll();
    }
    return pq.peek();
  }
}