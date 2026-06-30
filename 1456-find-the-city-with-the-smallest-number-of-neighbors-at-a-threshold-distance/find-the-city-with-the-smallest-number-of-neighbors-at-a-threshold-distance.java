class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int mat[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.MAX_VALUE;

                if (i == j)
                    mat[i][j] = 0;
            }
        }

        for (int[] e : edges) {
            mat[e[0]][e[1]] = e[2];
            mat[e[1]][e[0]] = e[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
        }

        int city = -1;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (mat[i][j] <= distanceThreshold)
                    count++;
            }

            if (count <= minCount) { 
                minCount = count;
                city = i;
            }
        }

        return city;
    }
}