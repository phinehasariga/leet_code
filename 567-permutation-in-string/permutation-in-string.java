class Solution {
    public boolean checkInclusion(String s1, String s2) {
       if(s1.length() > s2.length()){
        return false;
       } 
       int[] s1freq = new int[26];
       int[] windowfreq = new int[26];

       for(char ch :  s1.toCharArray()){
        s1freq[ch - 'a']++;
       }
       int windowsize = s1.length();

       for(int right = 0;right < s2.length();right++){
        windowfreq[s2.charAt(right) - 'a']++;
        if(right >= windowsize){
            windowfreq[s2.charAt(right - windowsize) - 'a']--;
        }
        if(Arrays.equals(s1freq,windowfreq)){
            return true;
        }
       }
       return false;
    }
}