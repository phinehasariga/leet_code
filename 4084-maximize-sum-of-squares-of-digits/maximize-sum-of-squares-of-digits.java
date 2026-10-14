public class Solution {
    public String maxSumOfSquares(int num, int sum) {

        if (sum > num * 9) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
    
        int nines = sum / 9;
        for (int i = 0; i < nines; i++) {
            sb.append('9');
        }
        
        int remainder = sum % 9;
        if (nines < num) {
            sb.append(remainder);
        }
        
        int remainingZeros = num - nines - (remainder > 0 || nines < num ? 1 : 0);
        for (int i = 0; i < remainingZeros; i++) {
            sb.append('0');
        }
        
        return sb.toString();
    }
}
