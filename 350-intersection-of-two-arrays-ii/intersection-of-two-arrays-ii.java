class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                resultList.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}