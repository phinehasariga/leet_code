class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
                Arrays.sort(nums);
        long count = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int left = lower - nums[i];
            int right = upper - nums[i];
            // Find the first index j > i where nums[j] >= left
            int lowerBound = findLowerBound(nums, i + 1, n - 1, left);
            // Find the last index j > i where nums[j] <= right
            int upperBound = findUpperBound(nums, i + 1, n - 1, right);
            if (lowerBound <= upperBound) {
                count += (upperBound - lowerBound + 1);
            }
        }
        return count;
    }

    private int findLowerBound(int[] nums, int left, int right, int target) {
        int low = left;
        int high = right;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int findUpperBound(int[] nums, int left, int right, int target) {
        int low = left;
        int high = right;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}