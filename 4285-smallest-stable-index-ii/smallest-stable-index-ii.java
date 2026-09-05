class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] pl = new int[n];
        int[] pr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(nums[i],max);
            pl[i] = max;
        }
        for(int i=n-1;i>=0;i--){
            min = Math.min(nums[i],min);
            pr[i] = min;
        }
        for(int i=0;i<n;i++){
            if(pl[i] - pr[i] <= k){
                ans = Math.min(ans,i);
            }
        }
        if(ans < n){
            return ans;
        }
        return -1;
    }
}