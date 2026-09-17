class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        java.util.Arrays.fill(best, Integer.MAX_VALUE);
        
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int minLenSoFar = Integer.MAX_VALUE;
        
        for (int l = 0, r = 0; r < n; ++r) {
            sum += arr[r];
            
            while (sum > target) {
                sum -= arr[l++];
            }
            
            if (sum == target) {
                int currentLen = r - l + 1;
                if (l > 0 && best[l - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, best[l - 1] + currentLen);
                }
                minLenSoFar = Math.min(minLenSoFar, currentLen);
            }
            
            best[r] = minLenSoFar;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}