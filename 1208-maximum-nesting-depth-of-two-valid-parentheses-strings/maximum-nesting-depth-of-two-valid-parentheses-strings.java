class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] result = new int[n];
        int currentDepth = 0;

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                result[i] = currentDepth % 2; 
                currentDepth++;
            } else {
                currentDepth--;
                result[i] = currentDepth % 2;
            }
        }

        return result;
    }
}