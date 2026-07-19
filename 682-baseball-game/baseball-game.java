class Solution {
    public int calPoints(String[] operations) {
        Stack<String> stack = new Stack<>();
        int count = 0;
        for(String s : operations){
            if(!s.equals("+") && !s.equals("D") && !s.equals("C")){
                stack.push(s);
            }
            if(s.equals("+")){
                int val1 = Integer.parseInt(stack.peek());
                stack.pop();
                String a = String.valueOf(val1);
                int val2 = Integer.parseInt(stack.peek());
                stack.pop();
                String b = String.valueOf(val2);
                int res = val1 + val2;
                String ans = String.valueOf(res);
                stack.push(b);
                stack.push(a);
                stack.push(ans);

            }if(s.equals("D")){
                int res = Integer.parseInt(stack.peek()) + Integer.parseInt(stack.peek());
                String val = String.valueOf(res);
                stack.push(val);
            }if(s.equals("C")){
               
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            count += Integer.parseInt(stack.peek());
            stack.pop();
        }
        return count;
    }
}