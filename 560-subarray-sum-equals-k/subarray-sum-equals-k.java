class Solution {
    public int subarraySum(int[] nums, int k) {
        int ps = 0;
        int count = 0;
        HashMap<Integer,Integer> psfrequency = new HashMap<>();
        psfrequency.put(0,1);
        for(int num:nums){
            ps += num;
            if(psfrequency.containsKey(ps-k)){
                count += psfrequency.get(ps-k);
            }
            psfrequency.put(ps,psfrequency.getOrDefault(ps,0)+1);
        }
        return count;
    }
}