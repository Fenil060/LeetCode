class Solution {
    int dr[] = { -1, 0, 1, 0 };
    int dc[] = { 0, 1, 0, -1 };

    public int countIslands(int[][] grid, int k) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    long sum = dfs(i, j, grid);
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public long dfs(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return 0;
        }

        long sum = grid[i][j];
        grid[i][j] = 0;

        for (int l = 0; l < 4; l++) {
            int nr = i + dr[l];
            int nc = j + dc[l];

            sum += dfs(nr, nc, grid);   
        }
        return sum;
    }
}