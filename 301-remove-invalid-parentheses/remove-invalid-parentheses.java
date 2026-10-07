class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) {
                    l--; 
                } else {
                    r++; 
                }
            }
        }

        List<String> result = new ArrayList<>();
        dfs(s, 0, l, r, result);
        return result;
    }

    private void dfs(String s, int startIndex, int l, int r, List<String> result) {
       
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            
            if (i > startIndex && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            
            if (r > 0 && s.charAt(i) == ')') {
                String nextStr = s.substring(0, i) + s.substring(i + 1);
                dfs(nextStr, i, l, r - 1, result);
            } 
            
            else if (l > 0 && s.charAt(i) == '(') {
                String nextStr = s.substring(0, i) + s.substring(i + 1);
                dfs(nextStr, i, l - 1, r, result);
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false; 
                }
            }
        }
        return count == 0;
    }
}