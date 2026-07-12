class Solution {
    static class Edge {
        int dest;
        int wt;

        Edge(int d, int w) {
            this.dest = d;
            this.wt = w;
        }
    }

    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        ArrayList<Edge> graph[] = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        boolean[] vis = new boolean[n + 1];
        dfs(1, graph, vis);
        return ans;
    }

    public void dfs(int curr, ArrayList<Edge>[] graph, boolean[] vis) {
        vis[curr] = true;

        for (Edge e : graph[curr]) {
            ans = Math.min(ans, e.wt);

            if (!vis[e.dest]) {
                dfs(e.dest, graph, vis);
            }
        }
    }
}