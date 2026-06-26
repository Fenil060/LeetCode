class Solution {
    int dr[] = { -1, 0, 1, 0 }; // t r b l
    int dc[] = { 0, 1, 0, -1 };
    int m;
    int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int island = 0;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, vis);
                    island++;
                }
            }
        }
        return island;
    }

    public void dfs(char[][] grid, int r, int c, boolean[][] vis) {
        vis[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < m && nc < n && !vis[nr][nc] && grid[nr][nc] == '1') {
                vis[nr][nc] = true;
                dfs(grid, nr, nc, vis);
            }
        }
    }
}