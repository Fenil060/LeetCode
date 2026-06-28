class Solution {
    static class Pair {
        int dest;
        int dist;

        public Pair(int dest, int d) {
            this.dest = dest;
            this.dist = d;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int path[] = new int[n + 1];
        ArrayList<Pair>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int time[] : times) {
            int u = time[0];
            int v = time[1];
            int d = time[2];

            graph[u].add(new Pair(v, d));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.dist - b.dist));

        pq.add(new Pair(k, 0));

        Arrays.fill(path, Integer.MAX_VALUE);
        path[k] = 0;
        path[0] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (curr.dist > path[curr.dest])
                continue;

            for (Pair next : graph[curr.dest]) {

                if (curr.dist + next.dist < path[next.dest]) {

                    path[next.dest] = curr.dist + next.dist;
                    pq.offer(new Pair(next.dest, path[next.dest]));
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (path[i] == Integer.MAX_VALUE)
                return -1;

            max = Math.max(max, path[i]);
        }

        return max;
    }
}