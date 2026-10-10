class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalK = (long) k1 + k2;
        long totalDiff = 0;
        int maxDiff = 0;
        int[] count = new int[100001];

        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            if (d > 0) {
                count[d]++;
                totalDiff += d;
                maxDiff = Math.max(maxDiff, d);
            }
        }
        if (totalDiff <= totalK) {
            return 0;
        }
        for (int i = maxDiff; i > 0 && totalK > 0; i--) {
            if (count[i] > 0) {
                long reduce = Math.min((long) count[i], totalK);
                count[i] -= reduce;
                count[i - 1] += (int) reduce;
                totalK -= reduce;
            }
        }
        long minSumSquare = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (count[i] > 0) {
                minSumSquare += (long) count[i] * i * i;
            }
        }

        return minSumSquare;
    }
}
