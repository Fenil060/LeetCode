class Solution {
    static class Pair {
        int r;
        int c;
        int l;

        public Pair(int r, int c, int l){
            this.r = r;
            this.c = c;
            this.l = l;
        }
    }

    int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        boolean[][] vis = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        vis[0][0] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (curr.r == n - 1 && curr.c == n - 1)
                return curr.l;

            for (int i = 0; i < 8; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !vis[nr][nc] && grid[nr][nc] == 0) {
                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc, curr.l + 1));
                }
            }
        }
        return -1;
    }
}