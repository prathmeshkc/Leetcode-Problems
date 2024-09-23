class Solution {
    private Set<String> set;
    private int[] mem;
    public int minExtraChar(String s, String[] dictionary) {
        this.set = new HashSet<>();
        this.mem = new int[s.length()];
        Arrays.fill(mem, -1);
        
        for(String str: dictionary) {
            set.add(str);
        }
        
        return solve(0, s, s.length());
    }
    
    private int solve(int idx, String s, int n) {
        //base
        if(idx >= n) return 0;
        
        //logic
        //check if we've already computed
        if(mem[idx] != -1) return mem[idx];
            
        //choose as extra char (meaning skip it in the substring)
        int res = 1 + solve(idx + 1, s, n);
        
        //dont choose as extra char (meaning dont skip it in the substring)
        for(int j = idx; j < n; j++) {
            String curr = s.substring(idx, j+1);
            if(set.contains(curr)) {
                res = Math.min(res, solve(j+1, s, n));
            }
        }
        return mem[idx] = res;
    }
}