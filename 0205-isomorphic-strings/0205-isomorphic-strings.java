class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if(!sMap.containsKey(sChar)) {
                sMap.put(sChar, tChar);
            } else {
                if(sMap.get(sChar) != tChar) {
                   return false; 
                }
            }
            
            if(!tMap.containsKey(tChar)) {
                tMap.put(tChar, sChar);
            } else {
                if(tMap.get(tChar) != sChar) {
                    return false;
                }
            }
        }
        
        return true;
        
    }
}