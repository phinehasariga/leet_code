class Solution {
    public int missingMultiple(int[] nums, int k) {
        if(nums.length == 1 && nums[0] % k == 0){
            if(k < nums[0]){
                return k;
            }
            else{
                return nums[0] * 2;
            }
        }
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<n+2;i++){
            int mul = i * k;
            boolean pres = false;
            for(int j = 0;j<n;j++){
                if(mul == nums[j]){
                    pres = true;
                    break;
                }
            }
            if(pres != true){
                min = Math.min(mul,min);
            }
            pres = false;
            
        }
        return min;
    }
}