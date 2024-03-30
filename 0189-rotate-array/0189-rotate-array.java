class Solution {
    public void rotate(int[] nums, int k) {
        //1. Reverse the complete array
        //2. Reverse first k elements
        //3. Reverse last n-k elements
        
        int n = nums.length;
        if(k >= n) {
            k = k % n;
        }
        
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        
    }
    
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
        
}