class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        //fill the map
        for(int i=0; i<n; i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int match = 0;
        
        for(int i=0; i<m; i++) {
            //incoming
            char in = s.charAt(i);
            
            if(map.containsKey(in)) {
                map.put(in, map.get(in) - 1);
                if(map.get(in) == 0) match++;
            }
            
            if(i >= n) {
                //outgoing
                char out = s.charAt(i - n);
                if(map.containsKey(out)) {
                    map.put(out, map.get(out) + 1);
                    if(map.get(out) == 1) match--;
                }
            }
            
            if(match == map.size()) res.add(i - n + 1);
        }
        
        return res;
    }
}