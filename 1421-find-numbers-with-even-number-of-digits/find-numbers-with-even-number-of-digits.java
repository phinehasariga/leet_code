class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (hasEvenDigits(num)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean hasEvenDigits(int num) {

        num = Math.abs(num);

        int digitCount = 0;
        if (num == 0) {
            digitCount = 1;
        } else {
            while (num > 0) {
                digitCount++;
                num /= 10;
            }
        }
        return digitCount % 2 == 0;
    }
}