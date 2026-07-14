class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        int idx = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(boxes.charAt(j) == '1'){
                    ans = ans + Math.abs(i-j);
                }
            }
            res[idx] = ans;
            idx++;
            ans = 0;
        }
        return res;
    }
}