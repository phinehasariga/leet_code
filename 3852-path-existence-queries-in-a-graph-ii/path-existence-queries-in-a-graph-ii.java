class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[arr[i][1]] = i;
        }

        int LOG = 20;
        int[][] jump = new int[LOG][n];

        
        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r + 1 < n && arr[r + 1][0] - arr[l][0] <= maxDiff) {
                r++;
            }
            jump[0][l] = r;
        }

        
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = pos[queries[i][0]];
            int v = pos[queries[i][1]];

            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            int cur = u;
            int steps = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[k][cur] < v) {
                    cur = jump[k][cur];
                    steps += 1 << k;
                }
            }

            if (jump[0][cur] >= v)
                ans[i] = steps + 1;
            else
                ans[i] = -1;
        }

        return ans;
    }
}
    