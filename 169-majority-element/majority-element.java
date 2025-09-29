class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int element = 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Set<Integer> keyset = map.keySet();
        for(Integer key : keyset){
            if(map.get(key) > nums.length/2){
                element = key;
            }
        }
        return element;
    }
}