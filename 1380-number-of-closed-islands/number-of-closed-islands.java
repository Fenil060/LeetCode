class Solution {
    int dr[] = { -1, 0, 1, 0 };
    int dc[] = { 0, 1, 0, -1 };

    public int closedIsland(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(i, j, grid)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // if (i < 0 || j < 0 || i >= n || j >= m)
        //     return false;

        if (grid[i][j] == 1)
            return true;

        if (i == 0 || j == 0 || i == n - 1 || j == m - 1)
            return false;

        grid[i][j] = 1;

        boolean closed = true;

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (!dfs(nr, nc, grid)) {
                closed = false;
            }
        }

        return closed;
    }
}