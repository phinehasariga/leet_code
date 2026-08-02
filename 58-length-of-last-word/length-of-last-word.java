class Solution {
    public int lengthOfLastWord(String s) {
        String[] res = s.trim().split("\\s+");
        String r = res[res.length-1];
        int ans = r.length();
        return ans;
    }
}