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
    
    private static class Pair {
        int sum;
        int count;
        public Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    
    private int res;
    
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return res;
    }
    
    private Pair solve(TreeNode root) {
        if(root == null) return new Pair(0, 0);
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        
        int totalSum = left.sum + right.sum + root.val;
        int totalCount = left.count + right.count + 1;
        
        if(root.val == totalSum/totalCount) res++;
        
        return new Pair(totalSum, totalCount);
    }
}