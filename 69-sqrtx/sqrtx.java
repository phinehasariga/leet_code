class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int low = 1, high = x, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // To avoid overflow, cast to long
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;       // store result and go right
                low = mid + 1;
            } else {
                high = mid - 1;  // go left
            }
        }

        return ans;
    }
}