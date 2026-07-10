class Solution {
    int dr[] = { -1, 0, 1, 0 };
    int dc[] = { 0, 1, 0, -1 };
    HashMap<Integer, Integer> map = new HashMap<>();

    public int largestIsland(int[][] grid) {
        int id = 2;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j, id);
                    map.put(id, area);
                    id++;
                }
            }
        }

        int ans = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> set = new HashSet<>();

                    for(int k=0; k<4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if(nr >=0 && nc >=0 && nr < grid.length && nc<grid[0].length && grid[nr][nc] != 0){
                            set.add(grid[nr][nc]);
                        }
                    }

                    int area = 1;

                    for(int island : set){
                        area += map.get(island);
                    }

                    ans = Math.max(ans, area);
                }
            }
        }

        if(ans == 0){
            return grid.length * grid.length;
        }
    return ans;
    }

    public int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;

        if (grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = id;

        int area = 1;

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            area += dfs(grid, nr, nc, id);
        }
        return area;
    }
}