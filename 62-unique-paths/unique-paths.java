class Solution {
    public int uniquePaths(int m, int n) {
                long result = 1;

        // We calculate C(m+n-2, m-1) or C(m+n-2, n-1)
        int totalSteps = m + n - 2;
        int stepsDown = Math.min(m - 1, n - 1); // to reduce computation

        for (int i = 1; i <= stepsDown; i++) {
            result = result * (totalSteps - stepsDown + i) / i;
        }

        return (int) result;
    }
}