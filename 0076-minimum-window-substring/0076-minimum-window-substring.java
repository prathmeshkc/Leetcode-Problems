class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        //freq. map of t's chars
        for(int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int match = 0;
        int min = s.length() + 1;
        int start = 0;
        int startSub = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) match++;
            }
            
            while(match == map.size()) {
                if(min > i - start + 1) {
                    min = i - start + 1;
                    startSub = start;
                }
                char out = s.charAt(start);
                if(map.containsKey(out)) {
                    if(map.get(out) == 0) match--;
                    map.put(out, map.get(out) + 1);
                }
                start++;
                
            }
        }
        
        
        return min > s.length() ? "" : s.substring(startSub, startSub + min);
    }
}