class Solution {
    public long countSubarrays(int[] nums, long k) {
                int left = 0;
        long currentSum = 0;
        long result = 0;
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum * (right - left + 1) >= k && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            if (currentSum * (right - left + 1) < k) {
                result += right - left + 1;
            }
        }
        return result;
        
    }
}