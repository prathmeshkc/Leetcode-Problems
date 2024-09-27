class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> res = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(
            (a, b) -> {
                int freq = b.getValue() - a.getValue();
                if(freq == 0) return a.getKey().compareTo(b.getKey());
                return freq;
            }
        );
        
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.add(entry);
        }
        
        while(k != 0) {
            res.add(pq.poll().getKey());
            k--;
        }
        
        return res;
    }
}