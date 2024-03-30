class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxIdx = 0;
        int max = 0;
        
        int res = 0;
        
        for(int i = 0; i<n; i++) {
            if(height[i] > max) {
                max = height[i];
                maxIdx = i;
            }
        }
        
        int l=0; int lw = 0; //lw is the initial height, therefore 0
        while(l < maxIdx) {
            if(lw > height[l]) {
                res += lw - height[l];
            } else {
                lw = height[l];
            }
            
            l++;
        }
        
        int r = n-1; int rw = 0; //rw is the initial height, therefore 0
        while(r > maxIdx) {
            if(rw > height[r]) {
                res += rw - height[r];
            } else {
                rw = height[r];
            }
            
            r--;
        }
        
        return res;
        
    }
}