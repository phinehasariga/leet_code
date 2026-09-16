class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        int ans = -1; 
        for(int i=0;i<nums.length;i++){
            if(s.contains(nums[i])){
                ans = nums[i];
            }
            s.add(nums[i]);
        }
        return ans;
    }
}