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
    // private Map<Integer, Integer> inMap;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) return null;
        
        int rootIdx = postorder.length-1;
        int rootVal = postorder[rootIdx];
        TreeNode root = new TreeNode(rootVal);
        
        if (postorder.length == 1) {
            return root;
        }
        
        int inRootIdx = -1;
        for(int i=0; i<inorder.length; i++) {
            if(inorder[i] == rootVal) {
                inRootIdx = i;
                break;
            }
        }
        if(inRootIdx == -1) return null;
        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, inRootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, 1 + inRootIdx, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int[] postRight = Arrays.copyOfRange(postorder, postLeft.length, rootIdx);
        
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        return root;
    }
    
}