class Solution {
    static class Pair {
        int r;
        int c;
        int h;

        public Pair(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    int dr[] = { -1, 0, 1, 0 }; //t, r, b, l
    int dc[] = { 0, 1, 0, -1 };

    public int[][] highestPeak(int[][] isWater) {
        Queue<Pair> q = new LinkedList<>();
        int m = isWater.length;
        int n = isWater[0].length;
        boolean vis[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                    isWater[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            vis[curr.r][curr.c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                int nh = curr.h + 1;

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !vis[nr][nc]
                        ) {
                    vis[nr][nc] = true;
                    isWater[nr][nc] = nh;
                    q.add(new Pair(nr, nc, nh));
                }
            }
        }
        return isWater;
    }
}