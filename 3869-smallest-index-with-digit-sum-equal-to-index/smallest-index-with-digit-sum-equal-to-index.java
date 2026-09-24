class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int ele = nums[i];
            if(ele > 9){
                while(ele > 0){
                    int digit = ele % 10;
                    ele = ele/10;
                    sum += digit;
                }
                if(sum == i){
                    ans = Math.min(ans,i);
                }
            }else{
                sum = ele;
                if(sum == i){
                    ans = Math.min(ans,i);
                }
            }
            sum = 0;
        }
        if(ans > n){
            return -1;
        }
        return ans;
    }
}