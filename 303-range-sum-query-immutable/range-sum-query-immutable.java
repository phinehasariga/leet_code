class NumArray {

    private int[] prefixsum;

    public NumArray(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        this.prefixsum = nums;
    }
    
    public int sumRange(int left, int right) {
        if(left == 0){
            return prefixsum[right];
        }
        return prefixsum[right] - prefixsum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */