class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
                int n = nums1.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos[nums1[i]];
        }

        // Count of elements to the left of i that are less than mapped[i]
        long[] left = new long[n];
        FenwickTree bitLeft = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            left[i] = bitLeft.query(mapped[i] - 1);
            bitLeft.update(mapped[i], 1);
        }

        // Count of elements to the right of i that are greater than mapped[i]
        long[] right = new long[n];
        FenwickTree bitRight = new FenwickTree(n);
        for (int i = n - 1; i >= 0; i--) {
            right[i] = bitRight.query(n - 1) - bitRight.query(mapped[i]);
            bitRight.update(mapped[i], 1);
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += left[i] * right[i];
        }

        return total;
    }

    class FenwickTree {
        long[] tree;
        int size;

        FenwickTree(int n) {
            tree = new long[n + 2];
            size = n + 2;
        }

        void update(int i, int delta) {
            i++;
            while (i < size) {
                tree[i] += delta;
                i += i & -i;
            }
        }

        long query(int i) {
            i++;
            long sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}