class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[][] connected = new boolean[n][n];

        for (int[] r : roads) {
            int u = r[0];
            int v = r[1];

            map.put(u, map.getOrDefault(u, 0) + 1);
            map.put(v, map.getOrDefault(v, 0) + 1);

            connected[u][v] = true;
            connected[v][u] = true;
        }

        int maxRank = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int rank =  map.getOrDefault(i, 0) + map.getOrDefault(j, 0);

                if (connected[i][j]) {
                    rank--;
                }

                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }
}