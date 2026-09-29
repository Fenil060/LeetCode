class Solution {
    Boolean dp[][][];
    public boolean hasValidPath(char[][] grid) {
        dp = new Boolean[100][100][200];
        return dfs(0, 0, 0, grid);
    }

    public boolean dfs(int i, int j, int count, char[][] grid) {
        if (grid[i][j] == '(') {
            count++;
        } else {
            count--;
        }

        if (count < 0) {
            return false;
        }

        if(dp[i][j][count] != null){
            return dp[i][j][count];
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return count == 0;
        }

        if (i + 1 < grid.length && dfs(i + 1, j, count, grid)) {
            return dp[i][j][count] = true;
        }

        if (j + 1 < grid[0].length && dfs(i, j + 1, count, grid)) {
            return dp[i][j][count] = true;
        }

        return dp[i][j][count] = false;
    }
}