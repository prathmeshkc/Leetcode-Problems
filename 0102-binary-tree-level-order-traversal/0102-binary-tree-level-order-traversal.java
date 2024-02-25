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
    private List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode curNode = q.poll();
                level.add(curNode.val);
                if(curNode.left != null) q.add(curNode.left);
                if(curNode.right != null) q.add(curNode.right);
            }
            res.add(level);
        }
        
        return res;
    }
}