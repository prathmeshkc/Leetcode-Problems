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
            res.add(new ArrayList<>(path));
            return;
        }
        
        
        ///logic
                
        //choose
        path.add(candidates[idx]);
        helper(candidates, idx, path, target - candidates[idx]);
        //backtrack
        path.remove(path.size()-1);
        
        //don't choose
        helper(candidates, idx+1, path, target);
    }
}