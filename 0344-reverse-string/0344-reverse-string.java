class Solution {
    public void reverseString(char[] s) {
        //Using two pointers method
        // run pointer s<=e. < for odd and = for even lengths
        int start = 0;
        int end = s.length - 1;
        
        while(start <= end) {
            swap(s, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}