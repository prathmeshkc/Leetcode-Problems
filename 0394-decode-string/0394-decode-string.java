class Solution {
    private int i = 0;
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        
        while(i < s.length()) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
                i++;
            } else if(c == '[') {
                i++;
                String decoded = decodeString(s);
                for(int k = 0; k < currNum; k++) {
                    currStr.append(decoded);
                }
                //reset
                currNum = 0;
            } else if(c == ']') {
                i++;
                return currStr.toString();
            } else {
                currStr.append(c);
                i++;
            }
        }
        
        return currStr.toString();
    }
}