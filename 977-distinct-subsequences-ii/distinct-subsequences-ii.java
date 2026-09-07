class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        
        int[] dp = new int[26];
        
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            
            int total = 1;
            
            for (int i = 0; i < 26; i++) {
                total = (total + dp[i]) % MOD;
            }
            
            dp[index] = total;
        }
        
        int ans = 0;
        
        for (int i = 0; i < 26; i++) {
            ans = (ans + dp[i]) % MOD;
        }
        
        return ans;
    }
}