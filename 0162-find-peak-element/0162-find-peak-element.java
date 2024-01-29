class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length-1;
        int low = 0;
        int high = n;
        
        
        while(low<=high) {
            int mid = (high-low)/2 + low;
            
            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == n || nums[mid+1] < nums[mid])) {
                return mid;
            } else if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == n || nums[mid+1] > nums[mid])) {
                low = mid + 1;
            } else if((mid == 0 || nums[mid-1] > nums[mid]) && (mid == n || nums[mid+1] < nums[mid])) {
                high = mid - 1;
            } else if((mid == 0 || nums[mid-1] > nums[mid]) && (mid == n || nums[mid+1] > nums[mid])) {
                // high = mid - 1;
                low = mid + 1;
            } 
        }
        
        return -1;
    }
}