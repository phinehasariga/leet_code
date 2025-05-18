class Solution {
    public List<String> letterCombinations(String digits) {
                List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] digitToLetters = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        
        backtrack(digits, digitToLetters, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtrack(String digits, String[] digitToLetters, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        char digit = digits.charAt(index);
        String letters = digitToLetters[digit - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, digitToLetters, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}