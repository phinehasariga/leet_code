class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=1;i<n;i++){
            int diff = nums[i] - nums[0];
            if(diff == 0 || diff % 2 != 0){
                continue;
            }
            int k = diff/2;
            Map<Integer,Integer>map = new HashMap<>();
            for(int num : nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            int[] res = new int[n/2];
            int idx = 0;
            boolean valid = true;
            for(int num : nums){
                if(map.get(num) == 0){
                    continue;
                }
                int next = num+2*k;
                if(!map.containsKey(next) || map.get(next) == 0){
                    valid = false;
                    break;
                }
                res[idx++] = num+k;
                map.put(num,map.get(num)-1);
                map.put(next,map.get(next)-1);
            }
            if(valid) return res;
        }
        return new int[]{};
    }
}