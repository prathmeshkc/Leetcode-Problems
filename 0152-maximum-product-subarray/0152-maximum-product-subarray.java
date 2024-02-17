class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int rPrd = 1;
        
        for(int i: nums) {
            rPrd *= i;
            
            max1 = Math.max(max1, rPrd);
            
            if(rPrd == 0) {
                rPrd = 1;
            }
        }
        
        rPrd = 1;
        for(int i=nums.length-1; i>=0; i--) {
            rPrd *= nums[i];
            
            max2 = Math.max(max2, rPrd);
            
            if(rPrd == 0) {
                rPrd = 1;
            }
        }
        
        return Math.max(max1, max2);
    }
}