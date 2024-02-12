class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = 1;
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        while(low < high && high<nums.length) {
            if(nums[high] - nums[low] == k) {
                set.add(new Pair(nums[low], nums[high]));
                low++;
                high++;
            } else if(nums[high] - nums[low] < k) {
                high++;
            } else {
                low++;
            }
            
            if(low == high) high++;
        }
        return set.size();
    }
}
