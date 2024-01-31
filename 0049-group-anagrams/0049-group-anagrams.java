class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Double, List<String>> map = new HashMap<>();
        
        for(String s: strs) {
            double product = findProduct(s);
            // if(!map.containsKey(product)) {
            //     map.put(product, new ArrayList<>());
            // }
            // map.get(product).add(s);
            
            if(map.containsKey(product)) {
                map.get(product).add(s);
            } else {
                map.put(product, new ArrayList<>());
                map.get(product).add(s);
            }
        }
        
        return new ArrayList<>(map.values());
    }
    
    private static double findProduct(String s) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        double result = 1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            result = result * primes[c-'a'];
        }
        return result;
    }
}