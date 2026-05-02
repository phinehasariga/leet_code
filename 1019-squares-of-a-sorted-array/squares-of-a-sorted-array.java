class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int s = nums[i]*nums[i];
            res[i] = s;
        }
        Arrays.sort(res);
        return res;
    }
}