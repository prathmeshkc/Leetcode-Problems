class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false);
        
        return new int[]{leftIdx, rightIdx};
    }
    
    private static int binarySearch(int[] nums, int target, boolean isLeftSearch) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = (high-low)/2 + low;
            
            if(target < nums[mid]) {
                high = mid - 1;
            } else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                if(isLeftSearch) {
                    if(mid == 0) return mid;
                    else if(nums[mid-1] == target) {
                        high = mid - 1;
                    } else {
                        return mid;
                    }
                    
                } else {
                    if(mid == nums.length-1) return mid;
                    else if(nums[mid+1] == target) {
                        low = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
        }
        
        return -1;
    }
}