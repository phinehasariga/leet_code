class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> s = new Stack<>();
        
        int[] ans = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i] =0;
            }else{
               ans[i]= Math.abs(i-s.peek());
            }
            s.push(i);
    
        }
     
        return ans;
    }
}