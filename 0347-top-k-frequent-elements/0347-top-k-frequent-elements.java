class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Make a map of <element, count>.
        //make a max heap of map's value
        
        Map<Integer, Integer> count = new HashMap<>();
        int[] res = new int[k];
        for(int e: nums) {
            if(count.containsKey(e)) {
                count.put(e, count.get(e) + 1);
            }else {
                count.put(e, 1);
            }
        }
        
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((entry1, entry2) -> entry2.getValue() - entry1.getValue());
        
        maxHeap.addAll(count.entrySet());
        
        for(int i=0; i<k; i++) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            if(entry != null) {
                res[i] = entry.getKey();    
            }
        }
        
        return res;
    }
}