class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            int[] freq = new int[26];

            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int idx = target.charAt(j) - 'a';

                if (freq[idx] == 0) {
                    possible = false;
                    break;
                }

                freq[idx]--;
            }

            if (!possible) {
                continue;
            }

            int current = target.charAt(i) - 'a';

            for (int c = current + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    freq[c]--;

                    StringBuilder ans = new StringBuilder(target.substring(0, i));
                    ans.append((char) ('a' + c));

                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            ans.append((char) ('a' + x));
                            freq[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}