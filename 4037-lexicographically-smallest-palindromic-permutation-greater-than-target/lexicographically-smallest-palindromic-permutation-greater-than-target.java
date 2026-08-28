class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        char mid = 0;
        int odd = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        if (mid != 0) {
            cnt[mid - 'a']--;
        }

        int half = n / 2;

        for (int i = 0; i < half; i++) {
            cnt[target.charAt(i) - 'a'] -= 2;
        }

        int negative = 0;
        int maxChar = -1;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] < 0) {
                negative++;
            } else if (cnt[i] > 0) {
                maxChar = i;
            }
        }

        if (negative == 0) {
            String left = target.substring(0, half);
            String right = new StringBuilder(left).reverse().toString();

            String candidate = left + (mid == 0 ? "" : String.valueOf(mid)) + right;

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        for (int i = half - 1; i >= 0; i--) {
            int current = target.charAt(i) - 'a';

            cnt[current] += 2;

            if (cnt[current] == 0) {
                negative--;
            }

            if (cnt[current] == 2) {
                maxChar = Math.max(maxChar, current);
            }

            if (negative > 0 || maxChar <= current) {
                continue;
            }

            int next = current + 1;

            while (next < 26 && cnt[next] == 0) {
                next++;
            }

            if (next == 26) {
                continue;
            }

            cnt[next] -= 2;

            StringBuilder left = new StringBuilder();

            for (int j = 0; j < i; j++) {
                left.append(target.charAt(j));
            }

            left.append((char) ('a' + next));

            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < cnt[j] / 2; k++) {
                    left.append((char) ('a' + j));
                }
            }

            String right = new StringBuilder(left).reverse().toString();

            if (mid != 0) {
                return left.toString() + mid + right;
            }

            return left.toString() + right;
        }

        return "";
    }
}