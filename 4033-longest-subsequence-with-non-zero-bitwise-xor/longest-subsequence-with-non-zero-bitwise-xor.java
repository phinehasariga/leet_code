class Solution {
    public int longestSubsequence(int[] nums) {
        if(nums.length == 1){
            if(nums[0] == 0){
                return 0;
            }else{
                return 1;
            }
        }
        int x = 0;
        int count = 0;
        int z = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                z++;
            }
            x ^= nums[i];
            count++;

        }
        if(z == nums.length){
            return 0;
        }
        int idx = 0;
        while(x == 0){
            if(nums[idx] != 0){
                x =  x ^ nums[idx];
                count--;
            }
            idx++;
        }
        return count;
    }
}