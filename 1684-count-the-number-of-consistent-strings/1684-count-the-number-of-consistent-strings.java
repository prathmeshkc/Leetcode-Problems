class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        
        Set<Character> allowedSet = new HashSet<>();
        for(int i = 0; i < allowed.length(); i++) {
            allowedSet.add(allowed.charAt(i));
        }
        
        for(String word: words) {
            boolean flag = false;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!allowedSet.contains(c)) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if(flag) count++;
        }
        
        return count;
    }
}