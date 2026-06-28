class Solution {
    static class Pair {
        int r;
        int c;
        int e;

        public Pair(int r, int c, int e) {
            this.r = r;
            this.c = c;
            this.e = e;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] effort = new int[m][n];
        for (int[] row : effort)
            Arrays.fill(row, Integer.MAX_VALUE);

        effort[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.e - b.e);
        pq.offer(new Pair(0, 0, 0));

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (curr.e > effort[curr.r][curr.c])
                continue;

            if (curr.r == m - 1 && curr.c == n - 1)
                return curr.e;

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    int diff = Math.abs(heights[curr.r][curr.c] - heights[nr][nc]);

                    int newEffort = Math.max(curr.e, diff);

                    if (newEffort < effort[nr][nc]) {
                        effort[nr][nc] = newEffort;
                        pq.offer(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }

        return 0;
    }
}