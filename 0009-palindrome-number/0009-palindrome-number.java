class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        
        int left = 0;
        int right = str.length() - 1;
        
        while(left <= right) {
            Character clft = str.charAt(left);
            Character crght = str.charAt(right);
            if(clft != crght) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}