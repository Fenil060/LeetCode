class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> rev = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rev.add(new ArrayList<>());
        }

        int outDegree[] = new int[n];

        for (int i = 0; i < n; i++) {
            outDegree[i] = graph[i].length;

            for (int nbr : graph[i]) {
                rev.get(nbr).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.remove();
            ans.add(node);

            for (int nbr : rev.get(node)) {
                outDegree[nbr]--;

                if (outDegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        Collections.sort(ans);
        return ans;

    }
}