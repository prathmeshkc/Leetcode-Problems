class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> allWords = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        
        String[] words = (s1 + " " + s2).split(" ");
        
        
        for (String word : words) {
            if (!allWords.add(word)) {
                duplicates.add(word);
            }
        }
        
        allWords.removeAll(duplicates);
        
        return allWords.toArray(new String[0]);
    }
}