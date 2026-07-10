class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int n = x;
        int reversed = 0;
        while(n > 0){
            reversed = reversed * 10 + (n % 10);
            n /= 10;
        }
        return x == reversed;
    }
}