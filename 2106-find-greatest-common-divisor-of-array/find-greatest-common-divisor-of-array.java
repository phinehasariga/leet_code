class Solution {
    public static int gcd(int a , int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a =temp;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int s = nums[0];
        int l = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i] < s){
                s = nums[i];
            }else if(nums[i] > l){
                l = nums[i];
            }
        }
        int ans = gcd(s,l);
        return ans;
    }
}