class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int maxlength = 0;
        int left = 0;
        for(int right = 0;right < n;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.get(nums[right]) > k){
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            maxlength = Math.max(maxlength,right-left+1);
        }
        return maxlength;
    }
}