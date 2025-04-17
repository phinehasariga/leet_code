class Solution {
    public int countPairs(int[] nums, int k) {
                Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!valueToIndices.containsKey(num)) {
                valueToIndices.put(num, new ArrayList<>());
            }
            valueToIndices.get(num).add(i);
        }
        
        int count = 0;
        for (List<Integer> indices : valueToIndices.values()) {
            int size = indices.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int idx1 = indices.get(i);
                    int idx2 = indices.get(j);
                    if ((idx1 * idx2) % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}