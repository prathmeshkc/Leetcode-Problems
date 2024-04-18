class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int lb = Integer.MIN_VALUE;
        int ub = Integer.MAX_VALUE;
        
        boolean isNeg = false;
        long res = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(i == 0) {
                if(c == '-') {
                    isNeg = true;
                    continue;
                } else if(c == '+') {
                    isNeg = false;
                    continue;
                }
            }
            
            if(Character.isDigit(c)) {
                res = res * 10 + (c - '0');
        
                if(isNeg) {
                    if(-res < lb) return lb;
                } else {
                    if(res > ub) return ub;
                }
            } else {
                break;
            }
        }
        
        if(isNeg) {
            res *= -1;
        }
        
        
        return (int)res;
    }
}