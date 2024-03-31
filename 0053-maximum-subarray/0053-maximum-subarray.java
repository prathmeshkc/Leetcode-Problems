class Solution {
    
    //Code to return the start and end indices of the max sum subarray
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int curSum = nums[0];

        int start = 0; int end = 0;
        int curStart = 0;

        for(int i = 1; i<n; i++) {
            curSum += nums[i];
            
            if(curSum < nums[i]) {
                curSum = nums[i];
                curStart = i;
            }
            
            if(curSum > max) {
                max = curSum;
                start = curStart;
                end = i;
            }
        }
        
        System.out.println(start);
        System.out.println(end);
        
        return max;
    }
}