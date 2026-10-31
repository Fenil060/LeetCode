class Solution {

    int m, n;
    int MOD = 1000000007;
    int[][] grid;
    long[][] dp;

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        dp = new long[m][n];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return (int) dfs(0, 0);
    }

    public long dfs(int r, int c) {

        if (r >= m || c >= n) return 0;

        if (r == m - 1 && c == n - 1) return 1;

        if (dp[r][c] != -1) return dp[r][c];

        // Right
        int nr = r;
        int nc = c + 1;

        boolean rightMove = true;

        while (nr < m && nc < n && grid[nr][nc] == 1) {
            if (rightMove) {
                nr++;
            } else {
                nc++;
            }
            rightMove = !rightMove;
        }

        long right = dfs(nr, nc);

        // Down
        nr = r + 1;
        nc = c;

        boolean downMove = true;

        while (nr < m && nc < n && grid[nr][nc] == 1) {
            if (downMove) {
                nc++;
            } else {
                nr++;
            }
            downMove = !downMove;
        }

        long down = dfs(nr, nc);

        return dp[r][c] = (right + down) % MOD;
    }
}