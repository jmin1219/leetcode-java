package trees;

public class MyBinaryTree {
    private TreeNode root;
    
    public MyBinaryTree() {
        this.root = null;
    }
    
    // INSERT: Add value maintaining BST property
    public void insert(int val) {
        if (root == null) {
          root = new TreeNode(val);
        } else {
          insertHelper(root, val);
        }
    }

    private void insertHelper(TreeNode node, int val) {
      if (val < node.val) {
        if (node.left == null) {
          node.left = new TreeNode(val);
        } else {
          insertHelper(node.left, val);
        }
      } else {
        if (node.right == null) {
          node.right = new TreeNode(val);
        } else {
          insertHelper(node.right, val);
        }
      }
    }

    // SEARCH: Find if value exists
    public boolean search(int val) {
      if (root == null) return false;
      return searchHelper(root, val) != null;
    }

    private TreeNode searchHelper(TreeNode node, int val) {
      if (node == null) return null;
      if (val == node.val) return node;
      if (val < node.val) {
          return searchHelper(node.left, val);
      } else {
          return searchHelper(node.right, val);
      }
    }
    
    // INORDER: Left → Root → Right (gives sorted order)
    public void inorder() {
        inorderHelper(root);
    }
    
    private void inorderHelper(TreeNode node) {
      if (node == null) return;
      inorderHelper(node.left);
      System.out.print(node.val);
      inorderHelper(node.right);
    }

    // PREORDER: Root → Left → Right (copies tree structure)
    public void preorder() {
        preorderHelper(root);
    }
    private void preorderHelper(TreeNode node) {
      if (node == null) return;
      System.out.print(node.val);
      preorderHelper(node.left);
      preorderHelper(node.right);
    }
    
    // POSTORDER: Left → Right → Root (deletes from leaves up)
    public void postorder() {
      postorderHelper(root);
    }
    private void postorderHelper(TreeNode node) {
      if (node == null) return;
      postorderHelper(node.left);
      postorderHelper(node.right);
      System.out.print(node.val);
    }
}