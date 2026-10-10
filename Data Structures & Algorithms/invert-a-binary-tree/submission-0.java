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
    public TreeNode invertTree(TreeNode root) {
        //Base case : if the tree is empty, return null
        if (root == null){
            return null;
        }
        
        //Temporarily assigning the nodes before they get overwritten
        TreeNode left = root.left;
        TreeNode right = root.right;

        //Inverting the binary tree
        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }
}
