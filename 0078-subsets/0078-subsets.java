class Solution {
    //Without Recursion
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            int size = res.size();
            for(int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(res.get(j)); //create a deep copy
                list.add(nums[i]);
                res.add(list);
            }
        }
        
        return res;
    }
}