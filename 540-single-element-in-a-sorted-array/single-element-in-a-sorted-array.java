class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if mid is even or odd to align the pairs
            if (mid % 2 == 1) mid--;

            // If the pair is valid, move to the right half
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        
        // The low index will point to the single element
        return nums[low];
    }
}