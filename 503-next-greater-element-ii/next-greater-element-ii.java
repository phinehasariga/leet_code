class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!s.isEmpty() && nums[i%n] >= s.peek()){
                s.pop();
            }
            if(i < n){
                if(s.isEmpty()){
                    res[i] = -1;
                }
                else{
                    res[i] = s.peek();
                }
            }
            s.push(nums[i % n]);
        }
        return res;
    }
}