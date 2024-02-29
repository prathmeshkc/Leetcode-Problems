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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.res = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return res;
    }
    
    private void helper(TreeNode root, int targetSum, int curSum, List<Integer> path) {
        //base
        if(root == null) return;
        
        //logic
        curSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(curSum == targetSum) res.add(new ArrayList<>(path));
        }
        
        helper(root.left, targetSum, curSum, path);
        helper(root.right, targetSum, curSum, path);
        
        //backtrack
        path.remove(path.size() - 1);
    }
}