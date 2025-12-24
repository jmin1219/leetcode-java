/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 * 
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have
 * to wait after the ith day to get a warmer temperature.
 * 
 * If there is no future day for which this is possible, keep answer[i] == 0.
 * 
 * Pattern: Monotonic Stack (decreasing)
 * Key insight: Store INDICES, not values. Stack holds days still "waiting"
 * for a warmer day. When we find one, we can calculate the distance.
 * 
 * Time: O(n) - each index pushed and popped at most once
 * Space: O(n) - stack can hold all indices in worst case
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution_739_DailyTemperatures {
    
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.push(i);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        Solution_739_DailyTemperatures sol = new Solution_739_DailyTemperatures();
        
        int[] test1 = {73,74,75,71,69,72,76,73};
        System.out.println("Test 1: " + Arrays.toString(sol.dailyTemperatures(test1)));
        // Expected: [1,1,4,2,1,1,0,0]
        
        int[] test2 = {30,40,50,60};
        System.out.println("Test 2: " + Arrays.toString(sol.dailyTemperatures(test2)));
        // Expected: [1,1,1,0]
        
        int[] test3 = {30,60,90};
        System.out.println("Test 3: " + Arrays.toString(sol.dailyTemperatures(test3)));
        // Expected: [1,1,0]
    }
}
