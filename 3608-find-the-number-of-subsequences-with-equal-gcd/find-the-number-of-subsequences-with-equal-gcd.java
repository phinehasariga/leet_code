class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][][] memo;
    private int[] nums;
    private int n;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        n = nums.length;

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        memo = new int[n][max + 1][max + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= max; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return dfs(0, 0, 0);
    }

    private int dfs(int idx, int g1, int g2) {
        if (idx == n) {
            return (g1 != 0 && g1 == g2) ? 1 : 0;
        }

        if (memo[idx][g1][g2] != -1) {
            return memo[idx][g1][g2];
        }

        long ans = 0;

        
        ans += dfs(idx + 1, g1, g2);

        
        ans += dfs(idx + 1, gcd(g1, nums[idx]), g2);

        
        ans += dfs(idx + 1, g1, gcd(g2, nums[idx]));

        memo[idx][g1][g2] = (int) (ans % MOD);
        return memo[idx][g1][g2];
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}