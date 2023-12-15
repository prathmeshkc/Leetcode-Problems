class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while(end < s.length()) {

            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c,0) + 1);
            //handle >1 case
            if(map.get(c) > 1) {
                while(s.charAt(start) != c) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    start++;
                }
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    start++;
                
            }
            res = Math.max(res, end-start+1);
            end++;
        }
        return res;
    }
}