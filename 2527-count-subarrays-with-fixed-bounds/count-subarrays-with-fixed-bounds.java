class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
                long res = 0;
        int lastInvalid = -1;
        int lastMin = -1;
        int lastMax = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastInvalid = i;
            }
            if (nums[i] == minK) {
                lastMin = i;
            }
            if (nums[i] == maxK) {
                lastMax = i;
            }
            // The number of valid subarrays ending at i is the number of positions
            // where both minK and maxK have been seen, and no invalid elements are included
            res += Math.max(0, Math.min(lastMin, lastMax) - lastInvalid);
        }
        return res;
    }
}