class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid]  > target){
                right = mid-1;
            }else{
                res[0] = mid;
                right = mid - 1;
            }
            
        }
        left = 0;
        right = nums.length -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target){
                left  = mid+1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                res[1] = mid;
                left = mid+1;
            }
        }
        return res;
    }
}