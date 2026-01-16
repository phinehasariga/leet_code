class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int val1 = 0;
        int val2 = 0;
        for(int i=0;i<nums.length;i++){
            val1 = val1^nums[i];
        }
        for(int i=0;i<=n;i++){
            val2 = val2^i;
        }
        return val1^val2;
    }
}