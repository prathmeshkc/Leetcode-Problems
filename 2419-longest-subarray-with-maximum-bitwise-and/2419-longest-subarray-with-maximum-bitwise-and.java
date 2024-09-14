class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        int streak = 0;
        int res = 0;
        
        for(int num: nums) {
            if(num > maxVal) {
                maxVal = num;
                streak = 0;
                res = 0;
            }
            
            if(num == maxVal) {
                streak++;
            } else {
                streak = 0;
            }
            
            res = Math.max(res, streak);
        }
        
        return res;
    }
}