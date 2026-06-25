class Solution {

    int dr[] = { -1, 0, 1, 0 };
    int dc[] = { 0, 1, 0, -1 };

    static class Pair {
        int r;
        int c;
        int v;

        public Pair(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && !vis[nr][nc] && mat[nr][nc] == 1) {
                    vis[nr][nc] = true;
                    mat[nr][nc] = curr.v + 1;
                    q.add(new Pair(nr, nc, curr.v + 1));
                }
            }
        }
        return mat;
    }
}