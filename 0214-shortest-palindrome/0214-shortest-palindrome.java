class Solution {
    //Using KMP algorithm
    
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "-" + rev;
        
        int[] lps = computeLPS(temp);
        int longestLPSLength = lps[lps.length-1];
        
        String culprit = rev.substring(0, s.length() - longestLPSLength);
        
        return culprit + s;
    }
    
    private int[] computeLPS(String s) {
        int n = s.length();
        int[] LPS = new int[n];
        
        LPS[0] = 0;
        int i = 1;
        int len = 0;
        
        while(i < n) {
            if(s.charAt(i) == s.charAt(len)) {
                len++;
                LPS[i] = len;
                i++;
            } else {
                if(len != 0){
                    len = LPS[len - 1];
                } else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }
        return LPS;
    }
}