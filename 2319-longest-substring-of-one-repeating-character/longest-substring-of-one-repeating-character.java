class Solution {

    class Node {
        int l, r;
        int pre, suf, best;
        char leftChar, rightChar;
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(String str, String queryCharacters, int[] queryIndices) {
        int n = str.length();
        s = str.toCharArray();
        tree = new Node[4 * n];
        build(1, 0, n - 1);

        int m = queryIndices.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            update(1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].best;
        }

        return ans;
    }

    private void build(int idx, int l, int r) {
        tree[idx] = new Node();
        tree[idx].l = l;
        tree[idx].r = r;

        if (l == r) {
            tree[idx].pre = 1;
            tree[idx].suf = 1;
            tree[idx].best = 1;
            tree[idx].leftChar = s[l];
            tree[idx].rightChar = s[l];
            return;
        }

        int mid = (l + r) / 2;
        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);
        pull(idx);
    }

    private void update(int idx, int pos, char c) {
        Node node = tree[idx];

        if (node.l == node.r) {
            s[pos] = c;
            node.leftChar = c;
            node.rightChar = c;
            node.pre = node.suf = node.best = 1;
            return;
        }

        int mid = (node.l + node.r) / 2;
        if (pos <= mid)
            update(idx * 2, pos, c);
        else
            update(idx * 2 + 1, pos, c);

        pull(idx);
    }

    private void pull(int idx) {
        Node node = tree[idx];
        Node left = tree[idx * 2];
        Node right = tree[idx * 2 + 1];

        node.leftChar = left.leftChar;
        node.rightChar = right.rightChar;

        int leftLen = left.r - left.l + 1;
        int rightLen = right.r - right.l + 1;

        node.pre = left.pre;
        if (left.pre == leftLen && left.rightChar == right.leftChar)
            node.pre += right.pre;

        node.suf = right.suf;
        if (right.suf == rightLen && left.rightChar == right.leftChar)
            node.suf += left.suf;

        node.best = Math.max(left.best, right.best);

        if (left.rightChar == right.leftChar) {
            node.best = Math.max(node.best, left.suf + right.pre);
        }
    }
}