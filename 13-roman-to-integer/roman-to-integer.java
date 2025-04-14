class Solution {
    public int romanToInt(String s) {
             Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        // Step 2: Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = romanMap.get(s.charAt(i));

            if (currValue < prevValue) {
                // Subtract if smaller value is before larger one
                total -= currValue;
            } else {
                total += currValue;
            }

            prevValue = currValue;
        }

        return total;  
    }
}