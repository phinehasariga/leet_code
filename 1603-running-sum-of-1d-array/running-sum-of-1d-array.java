class Solution {
    public int[] runningSum(int[] nums) {
        // for(int i=1;i<nums.length;i++){
        //     nums[i] = nums[i-1]+ nums[i];
        // }
        // return nums;
        int[] prefixsum = new int[nums.length];
        prefixsum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }
        return prefixsum;
    }

}