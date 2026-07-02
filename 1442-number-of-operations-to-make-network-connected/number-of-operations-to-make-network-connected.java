class Solution {
    ArrayList<Integer>[] graph;

    public int makeConnected(int n, int[][] connections) {
        boolean vis[] = new boolean[n];
        int cable = 0;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int c[] : connections) {
            int u = c[0];
            int v = c[1];
            cable++;
            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis);
                count++;
            }
        }
        if(n-1 > cable) return -1;
        return count - 1;
    }

    public void dfs(int n, boolean[] vis) {
        vis[n] = true;

        for (int i = 0; i < graph[n].size(); i++) {
            int curr = graph[n].get(i);
            
            if (!vis[curr]) {
                dfs(curr, vis);
            }
        }
    }
}