class Solution {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    static int count = 0;
    static int edge = 0;

    public int countCompleteComponents(int n, int[][] edges) {
        
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int [] edg : edges){
            int a = edg[0];
            int b = edg[1];

            graph[a].add(new Edge(a, b));
            graph[b].add(new Edge(b, a));
        }

        boolean []vis = new boolean[n];
        int ans = 0;

        for(int i=0; i<n; i++){
            count = 0;
            edge = 0;
            if(!vis[i]){
                dfs(i, graph, vis);

                if(count * (count-1) == edge){
                    ans++;
                }
            }
        }
    return ans;
    }

    public void  dfs(int node, ArrayList<Edge>[] graph , boolean[] vis){
        vis[node] = true;
        count++;
        edge += graph[node].size();

        for(int i=0; i<graph[node].size(); i++){
            Edge e = graph[node].get(i);

            if(!vis[e.dest]){
                dfs(e.dest, graph, vis);
            }
        }
    }
}