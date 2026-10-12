class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        final int MAX_BIT = 30; 
        int[] bitCount = new int[MAX_BIT];

        for (int num : nums) {
            for (int i = 0; i < MAX_BIT; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        long totalSum = 0;


        for (int step = 0; step < k; step++) {
            long currentNum = 0;
            for (int i = MAX_BIT - 1; i >= 0; i--) {
                if (bitCount[i] > 0) {
                    currentNum |= (1L << i);
                    bitCount[i]--;
                }
            }
            totalSum = (totalSum + (currentNum * currentNum) % MOD) % MOD;
        }

        return (int) totalSum;
    }
}
