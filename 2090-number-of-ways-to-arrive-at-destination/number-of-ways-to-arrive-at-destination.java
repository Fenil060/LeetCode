import java.util.*;

class Solution {

    static class Pair {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;

        // Graph
        ArrayList<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            graph[u].add(new Pair(v, wt));
            graph[v].add(new Pair(u, wt));
        }

        // Distance array
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        // Number of shortest paths
        long[] ways = new long[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            // Skip outdated entries
            if (curr.dist > dist[curr.node]) {
                continue;
            }

            for (Pair next : graph[curr.node]) {
                long newDist = curr.dist + next.dist;

                // Found a shorter path
                if (newDist < dist[next.node]) {
                    dist[next.node] = newDist;
                    ways[next.node] = ways[curr.node];
                    pq.offer(new Pair(next.node, newDist));
                } else if (newDist == dist[next.node]) {
                    ways[next.node] = (ways[next.node] + ways[curr.node]) % MOD;
                }

            }
        }

        return (int) ways[n - 1];
    }
}