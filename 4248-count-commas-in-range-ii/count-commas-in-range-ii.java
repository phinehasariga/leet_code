class Solution {
    public long countCommas(long n) {
        long count = 0;
        if(n < 999){
            return 0;
        }
        if(n >= 1000 && n <= 999999){
            count = (n - 1000)+1;
            return count;
        }
        if(n >= 1000000 && n <= 999999999){
            long ans = (n - 1000000) + 1;
            ans = ans * 2;
            ans = ans + 999000;
            count =  ans;
        }
        if(n >= 1000000000L && n <= 999999999999L){
            long ans = (n - 1000000000) + 1;
            ans = ans * 3;
            ans = ans + 999000 + 1998000000L;
            count = ans;
        }
        
        if(n >= 1000000000000L && n <= 999999999999999L){
            long ans = (n-1000000000000L) + 1;
            ans = ans * 4;
            ans = ans + 999000 + 1998000000L+ 2997000000000L;
            count = ans;
        }
        if(n == 1000000000000000L){
            return 3998998998999005L;
        }
        return count;
    }
}