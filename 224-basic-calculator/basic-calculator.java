
class Solution {
    public int calculate(String s) {
        int res = 0, num = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case ' ':
                    break;

                case '+':
                    res += sign * num;
                    sign = 1;
                    num = 0;
                    break;

                case '-':
                    res += sign * num;
                    sign = -1;
                    num = 0;
                    break;

                case '(':
                    stack.push(res);
                    stack.push(sign);
                    res = 0;
                    sign = 1;
                    break;

                case ')':
                    res += sign * num;
                    res *= stack.pop(); // sign
                    res += stack.pop(); // previous result
                    num = 0;
                    break;

                default:
                    if (Character.isDigit(c)) {
                        num = num * 10 + (c - '0');
                    }
                    break;
            }
        }
        return res + sign * num;
    }
}

