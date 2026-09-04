class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] pl = new int[n];
        int[] pr = new int[n];
        int res = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(nums[i],max);
            pl[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            min = Math.min(nums[i],min);
            pr[i] = min;
        }
        for(int i=0;i<n;i++){
            if(pl[i] - pr[i] <= k){
                res = Math.min(res,i);
            }
        }
        if(res > n){
            return -1;
        }
        return res;
    }
}