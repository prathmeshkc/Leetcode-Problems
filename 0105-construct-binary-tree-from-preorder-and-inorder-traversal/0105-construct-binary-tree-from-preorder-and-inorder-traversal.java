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
    private int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(0, inorder.length-1, preorder);
        
    }
    
    private TreeNode helper(int start, int end, int[] preorder) {
        //base
        if(start > end) return null;
        
        //logic
        int rootVal = preorder[idx];
        idx++;
        
        TreeNode root = new TreeNode(rootVal);
        
        int rootIdx = map.get(rootVal);
        
        root.left = helper(start, rootIdx - 1, preorder);
        root.right = helper(rootIdx + 1, end, preorder);
        
        return root;
    }
}