class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        Queue<Pair> pq = new PriorityQueue<Pair>(
            (a, b) -> Integer.compare(b.count, a.count)
        );
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            pq.add(new Pair(c, count));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            for(int i = 0; i < pair.count; i++) {
                sb.append(pair.c);
            }
        }
        
        return sb.toString();
        
    }
    
    private static class Pair {
        char c;
        int count;
        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}