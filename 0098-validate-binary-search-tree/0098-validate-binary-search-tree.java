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
    
    private List<Integer> list;
    
    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        helper(root);
        for(int i=1; i<list.size(); i++) {
            if(list.get(i) <= list.get(i-1)) return false;
        }
        
        return true;
    }
    
    private void helper(TreeNode root) {
        //base
        if(root == null) return;
        
        //logic
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
    
    
}