class Solution {
    public int maximumProduct(int[] nums) {
        int product1 = 1;
        int product2 = 1;
        if(nums.length == 3){
            product1 = nums[0] * nums[1] * nums[2];
            return product1;
        }
        Arrays.sort(nums);
        for(int i=nums.length - 3;i < nums.length;i++){
            product1 *= nums[i];
        }
        product2 = nums[0]*nums[1]*nums[nums.length-1];
        return  Math.max(product1,product2);
    }
}