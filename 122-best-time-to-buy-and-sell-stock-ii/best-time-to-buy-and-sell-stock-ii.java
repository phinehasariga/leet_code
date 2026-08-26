class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for(int i=1;i<prices.length;i++){
            int buyprice = prices[i];
            if(buyprice > prices[i-1]){
                maxprofit += buyprice - prices[i-1];
            }
        }
        return maxprofit;
    }
}