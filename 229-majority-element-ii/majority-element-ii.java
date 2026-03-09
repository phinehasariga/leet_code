class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int element = 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Set<Integer> keyset = map.keySet();
        for(int key:keyset){
            if(map.get(key) > nums.length/3){
                element = key;
                res.add(element);
            }
        }
        return res;
    }
}