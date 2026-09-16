class Solution {
    public boolean check(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > nums[(i+1) % nums.length]){
                count++;
            }
        }
        return count<=1;
    }
}