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
    int xDepth;
    int yDepth;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return x_parent != y_parent && xDepth == yDepth;
    }
    
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y) {
        //base
        if(root == null) return;
        //logic
        dfs(root.left, root, level+1, x, y);
        if(root.val == x) {
            xDepth = level;
            x_parent = parent;
        }
        
        if(root.val == y) {
            yDepth = level;
            y_parent = parent;
        }
        
        dfs(root.right, root, level+1, x, y);
    }
}