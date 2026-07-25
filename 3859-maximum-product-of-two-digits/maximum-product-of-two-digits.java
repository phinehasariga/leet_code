class Solution {
    public int maxProduct(int n) {
        // int p = 0;
        // int maxp = 0;
        // String s = Integer.toString(n);
        // for(int i=0;i<s.length();i++){
        //     char d = s.charAt(i);
        //     int digit = Character.getNumericValue(d);
        //     for(int j=i+1;j<s.length();j++){
        //         char d2 = s.charAt(j);
        //         int digit2 = Character.getNumericValue(d2);
        //         p = digit * digit2;
        //         maxp = Math.max(maxp,p);
        //     }
        // }
        // return maxp;
        int max1 = 0, max2 = 0;

        while (n > 0) {
            int digit = n % 10;

            if (digit > max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }

            n /= 10;
        }

        return max1 * max2;
    }
}