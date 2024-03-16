class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int start = 0;
        int max = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(set.contains(c)) {
                while(s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                set.add(c);
            }
            
            max = Math.max(max, set.size());
        }
        
        return max;
        
    }
}