class Solution {
    public String customSortString(String order, String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //fill freq. map
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //build the string
        for(int i=0; i<order.length(); i++) {
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                while(map.get(c) != 0) {
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
                }
                map.remove(c);
            }
        }
        
        //just append the keys in the map with value != 0
        for(char c: map.keySet()) {
            while(map.get(c) != 0) {
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
            }
        }
        
        return sb.toString();
    }
}