package trees;

public class Solution_104_MaxDepth {
    public int maxDepth(TreeNode root) {
        // Base case - what's the depth of an empty tree?
        if (root == null) return 0;
        // Recursive case - depth is 1 + max of children's depths
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
