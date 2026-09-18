class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, -1);
        
        for (int i = 0; i < n; i++) {
            int charIdx = s.charAt(i) - 'a';
            if (left[charIdx] == -1) {
                left[charIdx] = i;
            }
            right[charIdx] = i;
        }
        
        List<String> result = new ArrayList<>();
        int lastRight = -1;
        
        for (int i = 0; i < n; i++) {
            int charIdx = s.charAt(i) - 'a';
            if (i != left[charIdx]) {
                continue;
            }
            
            int validRight = checkInterval(s, i, left, right);
            if (validRight != -1) {
                if (i > lastRight) {
                    result.add(s.substring(i, validRight + 1));
                } else {
                    result.set(result.size() - 1, s.substring(i, validRight + 1));
                }
                lastRight = validRight;
            }
        }
        
        return result;
    }
    
    private int checkInterval(String s, int start, int[] left, int[] right) {
        int end = right[s.charAt(start) - 'a'];
        for (int j = start; j <= end; j++) {
            int charIdx = s.charAt(j) - 'a';
            if (left[charIdx] < start) {
                return -1;
            }
            end = Math.max(end, right[charIdx]);
        }
        return end;
    }
}