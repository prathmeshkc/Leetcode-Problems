class Solution {
    public int maxArea(int[] height) {
        //two pointer
        //if slant, consider the smaller one. so the height will be smaller bar's height
        //width is the diff bet the indices
        //area = width x height
        //keep track of result = max(area, current area)
        
        int res = 0;
        
        int start = 0;
        int end = height.length - 1;
        
        while(start < end) {
            int ht = Math.min(height[start], height[end]);
            int width = end - start;
            
            int area = width * ht;
            res = Math.max(res, area);
            if(height[start] > height[end]) {
                end--;
            }else {
                start++;
            }
        }
        
        return res;
        
        
    }
}