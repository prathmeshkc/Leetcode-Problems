class Solution {
    
    /*
    TC - O(logn to base 10)^2
    SC - O(logn to base 10)
    
    O(logn to base 10) because the max depth at which we can go is the number of digits in n. 
    For ex. n = 1234, we can start from 1 -> 10 -> 100 -> 1000 -> 10000 x(we can't go to 10,000)
    */
    
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k -= 1;
        
        while(k > 0) {//O(logn to base 10)
            int count = count(curr, curr + 1, n); //O(logn to base 10)
            
            if(count <= k) {
                curr++;
                k -= count; //skipping the elements under current prefix tree
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        
        return curr;
    }
    
    private int count(long curr, long next, int n) { //O(logn to base 10)
        int count = 0;
        while(curr <= n) {
            count += next - curr;
            
            curr *= 10;
            next *= 10;
            
            next = Math.min(next, n+1);
        }
        
        return count;
    }
}