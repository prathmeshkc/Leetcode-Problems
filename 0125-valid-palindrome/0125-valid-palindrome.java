class Solution {
    public boolean isPalindrome(String s) {
        
        
        if(s.equals(" ")){
            return true;
        }
        
      
        String plainText = "";
        
        for(char c: s.toCharArray()){
            if(Character.isLetter(c) || Character.isDigit(c)){
                plainText += c;
            }
        }
        
        plainText = plainText.toLowerCase();
        
        int start = 0;
        int end = plainText.length()-1;
        
        while(start<=end){
            if(plainText.charAt(start) == plainText.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
            
        }
        
        return true;
        
        
        
        
    }
}