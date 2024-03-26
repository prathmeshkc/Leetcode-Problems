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
        if(root == null) return 0;
        
        int res = 1;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root.left != null) q.add(root.left);
        if(root.right != null) q.add(root.right);
        
        while(!q.isEmpty()) {
            int size = q.size();
            res++;
            for(int i=0; i<size; i++) {
                TreeNode cur = q.poll();
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }
        
        return res;
        
    }
}