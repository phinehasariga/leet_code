class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> map = new HashSet<>();
        int maxlength = 0;
        int left = 0;
        for(int right = 0;right < n;right++){
            while(map.contains(s.charAt(right))){
                map.remove(s.charAt(left));
                left++;
            }
      
            map.add(s.charAt(right));
            maxlength = Math.max(maxlength,right - left+1);
        }
        return maxlength;
    }
}