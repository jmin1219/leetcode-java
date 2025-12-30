package trees;

import java.util.ArrayList;
import java.util.List;

public class Solution_144_PreorderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> arr = new ArrayList<>();
    helper(root, arr);
    return arr;
  }
  private void helper(TreeNode node, List<Integer> arr) {
    if (node == null) return;
    arr.add(node.val);
    helper(node.left, arr);
    helper(node.right, arr);
  }
}
