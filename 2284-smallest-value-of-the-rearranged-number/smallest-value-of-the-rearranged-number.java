class Solution {
    public long smallestNumber(long num) {
        if(num == 0){
            return 0;
        }
        boolean negative = num < 0;
        char[] digits = String.valueOf(Math.abs(num)).toCharArray();
        Arrays.sort(digits);
        if(negative){
            StringBuilder sb = new StringBuilder();
            for(int i=digits.length-1;i>=0;i--){
                sb.append(digits[i]);
            }
            return -Long.parseLong(sb.toString());
        }else{
            int i=0;
            while(digits[i] == '0')i++;
            char temp = digits[0];
            digits[0] = digits[i];
            digits[i] = temp;

            return Long.parseLong(new String(digits));
        }
    }
}