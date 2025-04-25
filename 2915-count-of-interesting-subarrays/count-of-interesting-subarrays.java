class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
                int n = nums.size();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int val = nums.get(i) % modulo == k ? 1 : 0;
            prefix[i + 1] = (prefix[i] + val) % modulo;
        }
        
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1); // prefix[0] is 0, mod is 0
        long result = 0;
        
        for (int i = 1; i <= n; i++) {
            int current = prefix[i];
            int target = (current - k + modulo) % modulo;
            result += countMap.getOrDefault(target, 0);
            countMap.put(current, countMap.getOrDefault(current, 0) + 1);
        }
        
        return result;
    }
}