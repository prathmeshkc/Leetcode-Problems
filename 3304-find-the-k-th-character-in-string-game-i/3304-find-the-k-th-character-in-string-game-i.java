class Solution {
    public char kthCharacter(int k) {
        String word = "a";
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        
        while(sb.length() < k) {
            StringBuilder generated = new StringBuilder();
            for(int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                int idx = (int) c + 1;
                if(c == 'z') idx = 97;
                
                generated.append(Character.toString((int) idx));
            }
            sb.append(generated.toString());
        }
        
        return sb.charAt(k-1);
    }
}