class Solution {
    public long maxAlternatingSum(int[] nums, int[][] swaps) {
        int n = nums.length;

        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : swaps) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] vis = new boolean[n];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, graph, vis, component);

                int even = 0;
                int odd = 0;

                ArrayList<Integer> values = new ArrayList<>();
                for (int idx : component) {
                    values.add(nums[idx]);

                    if (idx % 2 == 0) {
                        even++;
                    } else {
                        odd++;
                    }
                }

                Collections.sort(values);

                for (int j = 0; j < odd; j++) {
                    ans -= values.get(j);
                }

                for (int j = odd; j < values.size(); j++) {
                    ans += values.get(j);
                }
            }
        }
        return ans;
    }

    public void dfs(int node, ArrayList<Integer>[] graph, boolean[] vis, ArrayList<Integer> component) {
        vis[node] = true;
        component.add(node);

        for (int next : graph[node]) {
            if (!vis[next]) {
                dfs(next, graph, vis, component);
            }
        }
    }
}