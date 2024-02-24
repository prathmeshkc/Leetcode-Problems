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
    int res;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }
    
    private void helper(TreeNode root, int prevNum) {
        //base
        if(root == null) return;
        
        //logic
        int curNum = prevNum*10 + root.val;
        
        helper(root.left, curNum);
        
        if(root.left == null && root.right == null) {
            res += curNum;
            return;
        }
        
        helper(root.right, curNum);        
    }
    
    
}