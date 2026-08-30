class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int maxidx = 0;
        int minidx = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(nums[i] < min){
                min = nums[i];
                minidx = i;
            }
            if(nums[i] > max){
                max = nums[i];
                maxidx = i;
            }
        }

        int fd = Math.max(maxidx,minidx)+1;
        int bd = n - Math.min(maxidx,minidx);
        int fbd = Math.min(maxidx,minidx)+ (n-Math.max(maxidx,minidx)) + 1;

        int ans = Math.min(fd,bd);
        ans = Math.min(ans,fbd);
        return ans;

    }
}