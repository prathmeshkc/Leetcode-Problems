class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);
        return res;
    }
    
    private void helper(int[] candidates, int pivot, List<Integer> path, int target) {
        //base
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        if(target < 0) return; //IMP condition. Otherwise, StackOverflow
        
        //for-loop based recursion
        for(int i = pivot; i < candidates.length; i++) {
            
            //action
            path.add(candidates[i]);
            
            //recurse
            helper(candidates, i, path, target - candidates[i]);
            
            //backtrack
            path.remove(path.size() - 1);
            
        }
        
    }
}