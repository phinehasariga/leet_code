class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int s = 0;
        int cs = 0;
        for(int i=0;i<n;i++){
            s += i;
            cs += nums[i];
        }
        s+= n;
        return s - cs;
    }
}