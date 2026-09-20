class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int pos = Character.toLowerCase(c) - 'a' + 1;
            int res = Math.abs(26 - pos) + 1;
            ans += (i+1) * res;
        }
        return ans;
    }
}