class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentchildren = 0;
        int cookieindex = 0;
        while(cookieindex < s.length && contentchildren < g.length){
            if(s[cookieindex] >= g[contentchildren]){
                contentchildren++;
            }
            cookieindex++;
        }
        return contentchildren;
    }
}