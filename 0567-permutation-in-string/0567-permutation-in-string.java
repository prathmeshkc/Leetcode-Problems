class Solution {
    
   
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
            
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        Arrays.fill(s1Count,0);
        Arrays.fill(s2Count,0);
        
        //First, fill both the arrays with initial window values
        for(int i=0; i<s1.length(); i++){
            s1Count[(int)s1.charAt(i) - (int)'a'] += 1;
            s2Count[(int)s2.charAt(i) - (int)'a'] += 1;
        }
        
        int matches = 0;
        
        //Check for first window
        for(int i=0; i<26; i++){
            if(s1Count[i] == s2Count[i]){
                matches += 1;
            }
        }
        
        int start = 0;
        
        for(int i=s1.length(); i<s2.length(); i++){
            if(matches == 26){
                return true;
            }
            
            int index = (int)s2.charAt(i) - (int)'a';
            s2Count[index] += 1;
            if(s1Count[index] == s2Count[index]){
                matches += 1;
            }else if((s1Count[index] + 1) == s2Count[index]){
                matches -= 1;
            }
            
            
            int indexStart = (int)s2.charAt(start) - (int)'a';
            s2Count[indexStart] -= 1;
            if(s1Count[indexStart] == s2Count[indexStart]){
                matches += 1;
            }else if((s1Count[indexStart] - 1) == s2Count[indexStart]){
                matches -= 1;
            }
            
            start+=1;
        }
        
        
        return matches == 26;       
    }
    
}