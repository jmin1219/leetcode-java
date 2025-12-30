package trees;

import java.util.ArrayList;
import java.util.List;

public class Solution_145_PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        helper(root, arr);
        return arr;
    }

    private void helper(TreeNode node, List<Integer> arr) {
        if (node == null) return;
        helper(node.left, arr);
        helper(node.right, arr);
        arr.add(node.val);
    }
}
