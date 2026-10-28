class Solution {

    int ans = Integer.MAX_VALUE;

    public int minCost(int[][] grid) {
        boolean dp[][][] = new boolean[grid.length][grid[0].length][1024];
        dfs(0, 0, 0, grid, dp);
        return ans;
    }

    public void dfs(int r, int c, int xor, int[][] grid, boolean[][][] dp){
        int n = grid.length;
        int m = grid[0].length;

        xor ^= grid[r][c];

        // Reached destination
        if (r == n - 1 && c == m - 1) {
            ans = Math.min(ans, xor);
            return;
        }

        if(dp[r][c][xor]){
            return;
        }

        dp[r][c][xor] = true;

        if(r+1 < n){
           dfs(r+1, c, xor, grid, dp);
        }

        if(c+1 < m){
           dfs(r, c+1, xor, grid, dp);
        }
    }
}