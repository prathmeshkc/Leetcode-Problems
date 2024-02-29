class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    
    private void helper(int[] nums, int pivot, List<Integer> path) {
        //logic
        res.add(new ArrayList<>(path));
        for(int i=pivot; i<nums.length; i++) {
            //action
            path.add(nums[i]);
            helper(nums, i+1, path);
            
            //backtrack
            path.remove(path.size()-1);
        }
    }
}