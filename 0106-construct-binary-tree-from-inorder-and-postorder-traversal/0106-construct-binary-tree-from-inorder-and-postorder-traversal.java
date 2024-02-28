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
    private Map<Integer, Integer> map;
    private int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        idx = postorder.length - 1;
        
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(0, inorder.length - 1, postorder);
    }
    
    private TreeNode helper(int start, int end, int[] postorder) {
        //base
        if(start > end) return null;
        if(idx < 0) return null;
        
        //logic
        int rootVal = postorder[idx];
        int rootIdx = map.get(rootVal);
        idx--;
        
        TreeNode root = new TreeNode(rootVal);
        
        
        root.right = helper(rootIdx+1, end, postorder);
        root.left = helper(start, rootIdx-1, postorder);
        
        
        return root;
        
    }
}