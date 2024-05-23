class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    
    private void helper(int[] nums, int pivot, List<Integer> path) {
        //no base as recursion will stop at last index. For loop will take care of it.
        
        
        //logic
        res.add(new ArrayList<>(path)); //add at every node. Not just at the leaf
        for(int i = pivot; i < nums.length; i++) {
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i+1, path);
            //backtrack
            path.removeLast();
        }
        
    }
}