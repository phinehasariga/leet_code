class Solution {
    
            class BIT {
        int[] tree;

        BIT(int n) {
            tree = new int[n + 1];
        }

        void update(int idx) {
            while (idx < tree.length) {
                tree[idx]++;
                idx += idx & (-idx);
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & (-idx);
            }
            return sum;
        }
    }

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int[] values = prefix.clone();
        Arrays.sort(values);

        int m = 1;
        for (int i = 1; i < values.length; i++) {
            if (values[i] != values[m - 1]) {
                values[m++] = values[i];
            }
        }

        BIT bit = new BIT(m + 2);

        long ans = 0;

        for (int x : prefix) {
            int idx = Arrays.binarySearch(values, 0, m, x) + 1;

            ans += bit.query(idx - 1);

            bit.update(idx);
        }

    return (int) ans;
    }
}