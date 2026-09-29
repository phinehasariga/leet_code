class Solution {
    private int m, n;
    private char[][] grid;
    private Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;

        int totalLength = m + n - 1;

        if (totalLength % 2 != 0) return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        this.memo = new Boolean[m][n][totalLength + 1];

        return dfs(0, 0, 0);
    }

    private boolean dfs(int r, int c, int balance) {

        balance += (grid[r][c] == '(') ? 1 : -1;

        if (balance < 0) return false; 
        int remainingSteps = (m - 1 - r) + (n - 1 - c);
        if (balance > remainingSteps) return false;

        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        if (memo[r][c][balance] != null) {
            return memo[r][c][balance];
        }

        boolean foundPath = false;
        if (r + 1 < m) {
            foundPath = dfs(r + 1, c, balance);
        }
        if (!foundPath && c + 1 < n) {
            foundPath = dfs(r, c + 1, balance);
        }
        return memo[r][c][balance] = foundPath;
    }
}