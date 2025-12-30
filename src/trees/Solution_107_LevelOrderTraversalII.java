package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution_107_LevelOrderTraversalII {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null) return new ArrayList<>();

    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      result.add(0, level);
    }
    return result;
  }
}
