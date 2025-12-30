package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution_199_RightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int lvlSize = queue.size();

      for (int i = 0; i < lvlSize; i++) {
        TreeNode node = queue.poll();

        if (i == lvlSize - 1) result.add(node.val);

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
    }
    return result;
  }
}
