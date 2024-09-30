class Solution {
    public int kthGrammar(int n, int k) {
        //base
        if(n == 1 && k == 1) return 0;
        
        //logic
        int length = (int) Math.pow(2, n - 1);
        int mid = length / 2;
        
        if(k <= mid) {
            return kthGrammar(n-1, k);
        } else {
            return 1 - kthGrammar(n-1, k - mid);
        }
    }
}