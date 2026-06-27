class Solution {
    int color[];

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, graph))
                    return false;
            }
        }

        return true;
    }

    public boolean dfs(int node, int c, int[][] graph) {

        if (color[node] != -1) {
            return color[node] == c;
        }

        if (color[node] == -1)
            color[node] = c;

        for (int e : graph[node]) {
            int currColor = (c == 0) ? 1 : 0;
            if (!dfs(e, currColor, graph)) {
                return false;
            }
        }
        return true;
    }
}