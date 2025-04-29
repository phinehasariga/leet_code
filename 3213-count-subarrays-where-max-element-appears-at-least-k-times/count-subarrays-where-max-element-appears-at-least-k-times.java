class Solution {
    public long countSubarrays(int[] nums, int k) {
                int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        long count = 0;
        int n = nums.length;
        int left = 0, freq = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == maxVal) {
                freq++;
            }

            while (freq >= k) {
                count += (n - right); // all subarrays starting at `left` and ending at or after `right` are valid
                if (nums[left] == maxVal) {
                    freq--;
                }
                left++;
            }
        }

        return count;
    }
}