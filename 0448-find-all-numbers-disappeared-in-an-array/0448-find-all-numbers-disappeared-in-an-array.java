class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++) {
            int index = -1;
            if(nums[i] > 0) {
                index = nums[i] - 1;
            } else {
                index = Math.abs(nums[i]) - 1;
            }
            
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                res.add(i+1);
            }
        }
        
        return res;
    }
}