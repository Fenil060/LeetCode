class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int low = Math.max(grid[0][0], grid[n - 1][n - 1]);
        int high = n * n - 1;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean[][] vis = new boolean[n][n];

            if (dfs(0, 0, grid, vis, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean dfs(int r, int c, int[][] grid, boolean[][] vis, int water) {
        int n = grid.length;

        if (r < 0 || c < 0 || r >= n || c >= n)
            return false;

        if (vis[r][c] || grid[r][c] > water)
            return false;

        if (r == n - 1 && c == n - 1)
            return true;

        vis[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (dfs(nr, nc, grid, vis, water))
                return true;
        }

        return false;
    }
}