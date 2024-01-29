class Solution {
    public int findMin(int[] nums) {
        if(nums[0] <= nums[nums.length-1]) return nums[0];
        
        int n = nums.length-1;
        int low = 0;
        int high = n;
        
        while(low <= high) {
            if(nums[low] <= nums[high]) return nums[low];
            int mid = (high-low)/2 + low;

            if((mid == 0 || (nums[mid] < nums[mid-1])) && (mid == n || (nums[mid] < nums[mid+1]))) {
                return nums[mid];
            } else if(nums[low] <= nums[mid]) { //left sorted
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}