class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for(int i=nums2.length-1;i>=0;i--){
            while(!s.isEmpty() && nums2[i] >= nums2[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                map.put(nums2[i],-1);
            }else{
                map.put(nums2[i],nums2[s.peek()]);
            }
            s.push(i);
        }

        int[] res = new int[nums1.length];
        for(int i=0;i<res.length;i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}