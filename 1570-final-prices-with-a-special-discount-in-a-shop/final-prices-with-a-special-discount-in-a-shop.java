class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[prices.length];

        for(int i=prices.length - 1;i >= 0;i--){
            while(!s.isEmpty() && prices[i] < prices[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = prices[i];
            }
            else{
                
                res[i] = Math.abs(prices[i] - prices[s.peek()]);
            }
            s.push(i);
        }
        
        return res;
    }
}