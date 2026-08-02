class Solution {
    public int lengthOfLastWord(String s) {
        String[] res = s.trim().split("\\s+");
        return res[res.length-1].length();
    }
}