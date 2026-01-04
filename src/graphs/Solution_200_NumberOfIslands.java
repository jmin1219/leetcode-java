package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * 
 * Pattern: Grid BFS - treat 2D grid as implicit graph
 * - Each cell is a node
 * - Neighbors are adjacent cells (up/down/left/right)
 * - No explicit adjacency list needed — grid structure encodes neighbors
 * 
 * Approach:
 * 1. Iterate through grid
 * 2. When '1' found: increment count, BFS to mark all connected land as visited
 * 3. Mark visited by mutating grid ('1' -> '0') — avoids separate visited array
 * 
 * Key insight: Check bounds BEFORE marking, not after
 * 
 * Time: O(m*n) — visit each cell once
 * Space: O(min(m,n)) — queue size in worst case
 */
public class Solution_200_NumberOfIslands {
  public int numIslands(char[][] grid) {
    int count = 0;

    for (int i = 0; i < grid.length; i++) {       // rows
      for (int j = 0; j < grid[0].length; j++) {  // cols
        if (grid[i][j] == '1') {
          count++;
          bfs(grid, i, j);  // mark all connected land as visited
        }
      }
    }
    return count;
  }

  private void bfs(char[][] grid, int row, int col) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{row, col});

    while (!queue.isEmpty()) {
      int[] pos = queue.poll();
      int r = pos[0];
      int c = pos[1];

      // Check bounds and value FIRST — skip invalid positions
      if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != '1') continue;
      
      // Mark as visited
      grid[r][c] = '0';

      // Add all 4 neighbors
      queue.add(new int[]{r-1, c});
      queue.add(new int[]{r+1, c});
      queue.add(new int[]{r, c-1});
      queue.add(new int[]{r, c+1});
    }
  }
}
