class Solution {
    ArrayList<Integer> graph[];

    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!isBipartite(0, i, color))
                    return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int currentColor, int node, int[] color) {
        color[node] = currentColor;

        for (int nbr : graph[node]) {
            if (color[nbr] == -1) {
                if(isBipartite(1 - currentColor, nbr, color) == false){
                    return false;
                }
            } else if (color[nbr] == currentColor) {
                return false;
            }
        }
        return true;
    }

}