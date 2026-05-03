class Solution {
    public int findDuplicate(int[] nums) {
        // int n = nums.length;
        // int d = 0;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i] == nums[j]){
        //             d = nums[i];
        //         }
        //     }
        // }
        // return d;
        int d = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                d = num;
            }
            set.add(num);
        }
        return d;
    }

}