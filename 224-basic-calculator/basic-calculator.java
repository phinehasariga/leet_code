// class Solution {
//     public int calculate(String s) {
//         char[] chs = s.toCharArray();
//         int curRes = 0,val = 0, res = 0;
//         char sign = '+';

//         for(int i=0;i<chs.length;i++){
//             char c = chs[i];
//             if(Character.isDigit(c))
//             val = val*10+c-'0';

//             if(c=='+'||c=='*'||c==''|| i==chs.length-1){
//                 switch(sign){
//                     case('+'):
//                     res+=curRes;
//                     curRes = val;
//                     break;

//                     case('-'):
//                     res+=curRes;
//                     curRes=-val;
//                     break;

//                     case('*'):
//                     curRes *= val;
//                     break;

//                     case('/'):
//                     curRes /= val;
//                     break;
//                 }
//                 sign = c;
//                 val = 0;
//             }
//         }
//         return res + curRes;
//     }

// }
// class Solution {
//     public int calculate(String s) {
//         char[] chs = s.toCharArray();
//         int curRes = 0, val = 0, res = 0;
//         char sign = '+';

//         for (int i = 0; i < chs.length; i++) {
//             char c = chs[i];

//             if (Character.isDigit(c)) {
//                 val = val * 10 + (c - '0');
//             }

//             if ((!Character.isDigit(c) && c != '/') || i == chs.length - 1) {
//                 switch (sign) {
//                     case '+':
//                         res += curRes;
//                         curRes = val;
//                         break;
//                     case '-':
//                         res += curRes;
//                         curRes = -val;
//                         break;
//                     case '*':
//                         curRes *= val;
//                         break;
//                     case '/':
//                         curRes /= val;
//                         break;
//                 }
//                 sign = c;
//                 val = 0;
//             }
//         }

//         return res + curRes;
//     }
// }
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

