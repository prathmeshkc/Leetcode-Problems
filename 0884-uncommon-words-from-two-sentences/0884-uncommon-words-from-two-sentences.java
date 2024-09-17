class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Use a map to count occurrences of each word
        Map<String, Integer> wordCount = new HashMap<>();
        
        // Split the sentences and add words to the map
        for (String word : (s1 + " " + s2).split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Collect words that appear only once
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        // Convert the list to an array and return
        return result.toArray(new String[0]);
    }
}