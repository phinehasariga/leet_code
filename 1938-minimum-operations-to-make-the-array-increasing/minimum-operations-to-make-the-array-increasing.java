class Solution {
    public int minOperations(int[] nums) {
        int i = 1;
        int count = 0;
        while(i < nums.length){
            while(nums[i-1] >= nums[i]){
                nums[i] =  nums[i]+1;
                count++;
                
            }
            i++;
        }
        return count;
    }
}