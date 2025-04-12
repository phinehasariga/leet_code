class Solution {
    public boolean canJump(int[] nums) {
                int maxReach = 0; // Farthest index we can reach
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // If current index is beyond what we can reach
            if (i > maxReach) {
                return false;
            }
            
            // Update the farthest we can reach
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // If we can already reach the end
            if (maxReach >= n - 1) {
                return true;
            }
        }
        
        return true;
    }
}