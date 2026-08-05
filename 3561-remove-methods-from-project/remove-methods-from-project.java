class Solution {
    ArrayList<Integer>[] graph;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] i : invocations) {
            int u = i[0];
            int v = i[1];
            graph[u].add(v);
        }

        boolean vis[] = new boolean[n];
        HashSet<Integer> set = new HashSet<>();
        dfs(k, vis, set);

        for (int[] i : invocations) {
            int u = i[0];
            int v = i[1];
            if (!set.contains(u) && set.contains(v)) {
                List<Integer> ans = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    ans.add(j);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public void dfs(int t, boolean[] vis, HashSet<Integer> set) {
        vis[t] = true;
        set.add(t);

        for (int nbr : graph[t]) {
            if (!vis[nbr]) {
                dfs(nbr, vis, set);
            }
        }
    }
}