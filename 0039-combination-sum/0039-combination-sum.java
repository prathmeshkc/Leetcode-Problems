class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;    
    }
    
    private void helper(int[] candidates, int index, int amount, List<Integer> path) {
        
        //base
        if(index == candidates.length || amount < 0) return;
        if(amount == 0) {
            result.add(path);
            return;
        }
        
        //logic
        
        //not choose
        helper(candidates, index+1, amount, new ArrayList<>(path));
        
        //choose
        path.add(candidates[index]);
        helper(candidates, index, amount - candidates[index], path);
    }
}