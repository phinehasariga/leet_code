class Solution {
    public int divide(int dividend, int divisor) {
               int INT_MAX = Integer.MAX_VALUE; //  2^31 - 1
        int INT_MIN = Integer.MIN_VALUE; // -2^31

        // Handle overflow edge case
        if (dividend == INT_MIN && divisor == -1) {
            return INT_MAX;
        }

        // Use long to prevent overflow in abs calculation
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        int result = 0;

        // Subtract divisor multiples using bit shifting
        while (lDividend >= lDivisor) {
            long temp = lDivisor;
            int multiple = 1;

            while (lDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            lDividend -= temp;
            result += multiple;
        }

        // Apply the correct sign
        if ((dividend < 0) ^ (divisor < 0)) {
            result = -result;
        }

        return result; 
    }
}