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
    public int maxDepth(TreeNode root) {
        // Returning 0 if the tree is empty
        if (root == null){
            return 0;
        }

        // Assigning left and right depth
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // Comparing and returning the max depth
        return Math.max(left,right) + 1;
        
    }
}
