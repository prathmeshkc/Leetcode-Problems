class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int rSum = 0;
        
        for(int i: nums) {
            rSum += i;
            if(rSum > max) {
                max = rSum;
            }
            
            if(rSum < 0) {
                rSum = 0;
            }
        }
        
        return max;
    }
}