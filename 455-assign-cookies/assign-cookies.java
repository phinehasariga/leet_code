class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        // int contentchildren = 0;
        // int cookieindex = 0;
        // while(cookieindex < s.length && contentchildren < g.length){
        //     if(s[cookieindex] >= g[contentchildren]){
        //         contentchildren++;
        //     }
        //     cookieindex++;
        // }
        // return contentchildren;
        int count = 0;
        int x = s.length-1;
        int y = g.length-1;
        while(x>=0 && y>=0){
            if(s[x] >= g[y]){
                count++;
                y--;
                x--;
            }else{
                y--;
            }
        }
        return count;
    }
}