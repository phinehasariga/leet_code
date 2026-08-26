class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);

        int ans = num;

        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i) == '6'){
                sb.setCharAt(i,'9');
            }
            else if(sb.charAt(i) == '9'){
                sb.setCharAt(i,'6');
            }

            int val = Integer.parseInt(sb.toString());
            if(val >= num){
                ans = Math.max(ans,val);
            }

            sb.setLength(0);
            sb.append(num);
        }
        return ans;
    }

}