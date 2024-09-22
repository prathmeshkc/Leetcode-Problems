class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k -= 1;
        
        while(k > 0) {
            int count = count(curr, curr + 1, n);
            
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
    
    private int count(long curr, long next, int n) {
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