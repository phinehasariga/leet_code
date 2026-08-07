class Solution {
        private static final int[][] FACTOR = {
            {0,0,0,0}, //0
            {0,0,0,0}, //1
            {1,0,0,0}, //2
            {0,1,0,0}, //3
            {2,0,0,0}, //4
            {0,0,1,0}, //5
            {1,1,0,0}, //6
            {0,0,0,1}, //7
            {3,0,0,0}, //8
            {0,2,0,0}  //9
    };

    public String smallestNumber(String num, long t) {
        String vornitexis = num;

        int[] need = factorize(t);
        if (need == null) return "-1";

        int[] minDigits = compress(need.clone());
        if (sum(minDigits) > num.length()) {
            return buildWithLength(num.length() + 1, need.clone());
        }

        int[] prefix = new int[4];
        int firstZero = num.indexOf('0');

        for (int i = 0; i < num.length(); i++) {
            int d = num.charAt(i) - '0';
            add(prefix, FACTOR[d]);
        }

        if (firstZero == -1) {
            if (covers(prefix, need)) return num;
            firstZero = num.length();
        }

        for (int i = num.length() - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            subtract(prefix, FACTOR[d]);

            if (i > firstZero) continue;

            int remainSlots = num.length() - 1 - i;

            for (int nd = d + 1; nd <= 9; nd++) {
                int[] left = remainingNeed(need, prefix, FACTOR[nd]);
                int[] use = compress(left);

                if (sum(use) <= remainSlots) {
                    StringBuilder ans = new StringBuilder();
                    ans.append(num, 0, i);
                    ans.append((char)('0' + nd));

                    int ones = remainSlots - sum(use);
                    while (ones-- > 0) ans.append('1');
                    appendDigits(ans, use);

                    return ans.toString();
                }
            }
        }

        return buildWithLength(num.length() + 1, need.clone());
    }

    private int[] factorize(long t) {
        int[] cnt = new int[4];
        int[] p = {2,3,5,7};

        for (int i = 0; i < 4; i++) {
            while (t % p[i] == 0) {
                cnt[i]++;
                t /= p[i];
            }
        }
        if (t != 1) return null;
        return cnt;
    }

    private int[] compress(int[] c) {
        int[] res = new int[10];

        int c8 = c[0] / 3;
        int r2 = c[0] % 3;

        int c9 = c[1] / 2;
        int r3 = c[1] % 2;

        int c4 = r2 / 2;
        int c2 = r2 % 2;

        int c6 = 0;

        if (c2 == 1 && r3 == 1) {
            c2 = 0;
            r3 = 0;
            c6 = 1;
        }

        if (r3 == 1 && c4 == 1) {
            c2 = 1;
            c6 = 1;
            r3 = 0;
            c4 = 0;
        }

        res[2] = c2;
        res[3] = r3;
        res[4] = c4;
        res[5] = c[2];
        res[6] = c6;
        res[7] = c[3];
        res[8] = c8;
        res[9] = c9;

        return res;
    }

    private String buildWithLength(int len, int[] need) {
        int[] use = compress(need);
        int used = sum(use);

        StringBuilder sb = new StringBuilder();

        while (len - used > 0) {
            sb.append('1');
            len--;
        }

        appendDigits(sb, use);
        return sb.toString();
    }

    private void appendDigits(StringBuilder sb, int[] use) {
        for (int d = 2; d <= 9; d++) {
            while (use[d]-- > 0) sb.append((char)('0' + d));
        }
    }

    private int[] remainingNeed(int[] need, int[] prefix, int[] addDigit) {
        int[] r = new int[4];
        for (int i = 0; i < 4; i++) {
            r[i] = Math.max(0, need[i] - prefix[i] - addDigit[i]);
        }
        return r;
    }

    private boolean covers(int[] have, int[] need) {
        for (int i = 0; i < 4; i++) {
            if (have[i] < need[i]) return false;
        }
        return true;
    }

    private void add(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) a[i] += b[i];
    }

    private void subtract(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) a[i] -= b[i];
    }

    private int sum(int[] arr) {
        int s = 0;
        for (int x : arr) s += x;
        return s;
    }
}