class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text1.length()];
        int longest = 0;
        for(char c : text2.toCharArray()){
            int currlen = 0;
            for(int i=0;i<dp.length;i++){
                if(currlen < dp[i]){
                    currlen = dp[i];
                }
                else if(c == text1.charAt(i)){
                    dp[i] = currlen+1;
                    longest = Math.max(longest,currlen+1);
                }
            }
        }
        return longest;
    }
}