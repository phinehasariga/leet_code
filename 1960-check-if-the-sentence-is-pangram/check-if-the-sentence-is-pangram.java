class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        if(n < 26){
            return false;
        }
        Set<Character> set = new HashSet<>();
        for(int i=0;i<sentence.length();i++){
            char c = sentence.charAt(i);
            set.add(c);
        }
        int count = set.size();
        if(count == 26){
            return true;
        }
        return false;
    }

}