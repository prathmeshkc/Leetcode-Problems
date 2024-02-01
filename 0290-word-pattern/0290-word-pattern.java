class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ", 0);
        System.out.println(Arrays.toString(strs));
        if(pattern.length() != strs.length) return false;
        
        Map<Character, String> pMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();
        
        for(int i=0; i<pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            String str = strs[i];
            
            
            if(!pMap.containsKey(pChar)) {
                pMap.put(pChar, str);
            } else {
                if(!pMap.get(pChar).equals(str) ) {
                    return false;
                }
            }
            
            
            if(!sMap.containsKey(str)) {
                sMap.put(str, pChar);
            } else {
                if(sMap.get(str) != pChar) {
                    return false;
                }
            }
        }
        
        return true;
    }
}