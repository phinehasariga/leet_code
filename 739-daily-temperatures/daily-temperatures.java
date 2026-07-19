class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> s = new Stack<>();
        // HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        // map.put(temperatures[n-1],0);
        // s.push(n-1);
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res.add(0);
            }else{
               res.add(Math.abs(i-s.peek()));
            }
            s.push(i);
    
        }
        Collections.reverse(res);
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}