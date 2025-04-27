class Solution {
    public int countSubarrays(int[] nums) {
                int count = 0;
        for (int i = 0; i + 2 < nums.length; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            if (first + third == second / 2) {
                // Check if second is even to avoid integer division issues
                if (second % 2 == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}