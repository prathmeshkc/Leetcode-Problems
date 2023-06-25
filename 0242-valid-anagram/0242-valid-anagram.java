class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        if(s.length() != t.length()) {
            return false;
        }
        
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            if(!sMap.containsKey(c)) {
                sMap.put(c, 1);
            }else {
                sMap.put(c, sMap.get(c) + 1);
            }
        }
        
        for(int i=0; i< t.length(); i++) {
            char c = t.charAt(i);
            if(!tMap.containsKey(c)) {
                tMap.put(c, 1);
            }else {
                tMap.put(c, tMap.get(c) + 1);
            }
        }
        
        return sMap.equals(tMap);
        
    }
}