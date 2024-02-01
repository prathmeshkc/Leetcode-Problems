
class Solution {
    public int longestPalindrome(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if(map.get(c) >= 2) {
                    map.put(c, map.get(c) - 2);
                    result += 2;
                }
            } else {
                map.put(c, 1);
            }
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
                result = result + 1;
                break;
            }
        }
        
        return result;
    }
}