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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }
    
    private TreeNode dfs(TreeNode root, int target) {
        //base
        if(root == null) return null;
        //logic
        root.left = dfs(root.left, target);
        root.right = dfs(root.right, target);
        
        if(root.left == null && root.right == null && root.val == target){ 
            return null;
        }
        return root;
    }
}