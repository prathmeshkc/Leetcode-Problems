class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b-a); //Max Heap
        int result = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
            if(pq.size() > (nums.length-k)) {
                result = Math.min(pq.poll(), result); //log(n-k)
            }
        }
        
        return result;
    }
}