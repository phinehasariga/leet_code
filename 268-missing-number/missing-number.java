class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int actualsum = n*(n+1)/2;
        int resultsum = 0;
        for(int i=0;i<n;i++){
            resultsum += nums[i];
        }
        return actualsum - resultsum;
    }
}