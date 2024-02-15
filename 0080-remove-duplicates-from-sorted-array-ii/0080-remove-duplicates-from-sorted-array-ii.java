class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int cnt = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
                cnt = 1;
            } else {
                cnt++;
            }
            
            if(cnt <= 2) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        
        return slow;
    }
}