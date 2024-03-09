class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a); //Max heap
        int size = nums.length - k;
        int res = Integer.MAX_VALUE;
        for(int num: nums) {
            pq.add(num);
            if(pq.size() > size) {
                res = Math.min(res, pq.poll());
            }
        }
        
        return res;
        
    }
}