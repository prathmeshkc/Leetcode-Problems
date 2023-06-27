class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<>();
        
        
        
        if(strs.length == 1 && strs[0] == "") {
            return new ArrayList<List<String>>() {{
                add(Arrays.asList(""));
            }};
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str: strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String newStr = String.valueOf(charArr);
            
            if(map.containsKey(newStr)) {
                List<String> value = map.get(newStr);
                value.add(str);
                map.put(newStr, value);
            }else{
                List<String> value = new ArrayList<>();
                value.add(str);
                map.put(newStr, value);
            }
        }
        
        for(String key: map.keySet()) {
            res.add(map.get(key));
        }
        
        return res;
        
        
    }
}