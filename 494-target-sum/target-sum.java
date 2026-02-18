class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sm = 0;
        for(int num:nums)sm+=num;
        if(sm<Math.abs(target) || (sm+target)%2 != 0) return 0;
        int totalsum = (sm + target) /2;
        int[] dp = new int[totalsum + 1];
        dp[0] = 1;

        for(int num:nums){
            for(int t = totalsum;t >= num; t--){
                dp[t] += dp[t-num];
            }
        }
        return dp[totalsum];
    }
}