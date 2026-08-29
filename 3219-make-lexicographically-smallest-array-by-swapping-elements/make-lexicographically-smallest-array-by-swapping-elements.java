class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
                int n = nums.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] ans = new int[n];

        int start = 0;

        while (start < n) {
            int end = start;

            while (end + 1 < n &&
                   nums[indices[end + 1]] - nums[indices[end]] <= limit) {
                end++;
            }

            int[] positions = new int[end - start + 1];

            for (int i = start; i <= end; i++) {
                positions[i - start] = indices[i];
            }

            Arrays.sort(positions);

            for (int i = start; i <= end; i++) {
                ans[positions[i - start]] = nums[indices[i]];
            }

            start = end + 1;
        }

        return ans;
    }
}