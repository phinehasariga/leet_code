class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        for(int val : nums)
        numset.add(val);

        int lcs = 0;
        for(int val : numset){
            if(numset.contains(val-1)){
                continue;
            }else{
                int currnum = val;
                int currsub =1;
                while(numset.contains(currnum + 1)){
                    currnum++;
                    currsub++;
                }
                lcs = Math.max(lcs,currsub);
            }
        }
        return lcs;
    }
}