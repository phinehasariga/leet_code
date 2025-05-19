class Solution {
    public int maxProfit(int[] prices) {
                if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        // Fill left array
        int minPrice = prices[0];
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
        }
        
        // Fill right array
        int maxPrice = prices[n - 1];
        right[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
        }
        
        // Find the maximum profit
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        
        return maxProfit;
    }
}