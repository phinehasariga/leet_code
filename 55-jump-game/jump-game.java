class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxreach = 0;

        for(int i=0;i<n && i<=maxreach;i++){
            maxreach = Math.max(maxreach,i+nums[i]);
            if(maxreach >= n-1){
                return true;
            }
        }
        return false;
    }
}