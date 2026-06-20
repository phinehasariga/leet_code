class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        for(int start=0,end=n-1;start < end;start++,end--){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        for(int start = 0,end = k-1;start < end;start++,end--){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        for(int start = k,end = n-1;start < end;start++,end--){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}