class Solution {
    private static final long LIMIT = 1_000_001L;
    public String smallestPalindrome(String s, int k) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                middle = (char) ('a' + i);
                freq[i]--;
                break;
            }
        }

        int[] half = new int[26];
        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLen += half[i];
        }

        if (countPermutations(half) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int ch = 0; ch < 26; ch++) {
                if (half[ch] == 0) {
                    continue;
                }

                half[ch]--;

                long ways = countPermutations(half);

                if (ways >= k) {
                    left.append((char) ('a' + ch));
                    break;
                } else {
                    k -= ways;
                    half[ch]++;
                }
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        if (middle == 0) {
            return left.toString() + right;
        }

        return left.toString() + middle + right;
    }

    private long countPermutations(int[] cnt) {
        int total = 0;
        for (int x : cnt) {
            total += x;
        }

        long ans = 1;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;

            ans *= nCr(total, cnt[i]);

            if (ans >= LIMIT) {
                return LIMIT;
            }

            total -= cnt[i];
        }

        return ans;
    }

    private long nCr(int n, int r) {
        if (r > n) return 0;

        r = Math.min(r, n - r);

        long res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;

            if (res >= LIMIT) {
                return LIMIT;
            }
        }

        return res;
    }
}