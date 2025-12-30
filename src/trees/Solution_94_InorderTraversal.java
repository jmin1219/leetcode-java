package trees;

import java.util.ArrayList;
import java.util.List;

public class Solution_94_InorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> arr = new ArrayList<>();
    helper(root, arr);
    return arr;
  }
  private void helper(TreeNode node, List<Integer> arr) {
    if (node == null) return;
    helper(node.left, arr);
    arr.add(node.val);
    helper(node.right, arr);
  }
}
