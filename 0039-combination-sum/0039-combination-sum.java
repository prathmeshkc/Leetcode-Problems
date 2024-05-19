class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);
        return res;
    }
    
    private void helper(int[] candidates, int idx, List<Integer> path, int target) {
        //base
        if(idx == candidates.length || target < 0) return;
        
        if(target == 0) {
            res.add(path);
            return;
        }
        
        
        ///logic
        
        //don't choose
        helper(candidates, idx+1, new ArrayList<>(path), target);
        
        //choose
        path.add(candidates[idx]);
        helper(candidates, idx, new ArrayList<>(path), target - candidates[idx]);
    }
}