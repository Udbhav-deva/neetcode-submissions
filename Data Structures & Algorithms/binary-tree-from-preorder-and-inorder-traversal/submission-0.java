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
    private int preorderIndex = 0; 
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderMap.get(rootVal);

        root.left = dfs(preorder, inStart, mid - 1);
        root.right = dfs(preorder, mid + 1, inEnd);

        return root;
    }
}
