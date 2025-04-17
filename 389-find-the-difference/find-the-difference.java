class Solution {
    public char findTheDifference(String s, String t) {
                HashMap<Character, Integer> frequencyMap = new HashMap<>();
        
        // Count frequency of characters in s
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Check frequency in t
        for (char c : t.toCharArray()) {
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) - 1);
                if (frequencyMap.get(c) == 0) {
                    frequencyMap.remove(c);
                }
            } else {
                return c;
            }
        }
        
        // In case all characters in s are in t but one has an extra count
        for (char c : frequencyMap.keySet()) {
            if (frequencyMap.get(c) == -1) {
                return c;
            }
        }
        
        // Default return (shouldn't reach here as per problem statement)
        return ' ';
    }
}