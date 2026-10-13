/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    private int checkHeight(TreeNode root) {
        // Base case: An empty tree has a height of 0
        if (root == null) {
            return 0;
        }

        // Check left subtree height
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1; // Pass the unbalance signal up

        // Check right subtree height
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1; // Pass the unbalance signal up

        // If the current node is unbalanced, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Otherwise, return the actual height of this subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
