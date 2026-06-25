class Solution {
    ArrayList<Integer>[] graph;
    boolean[] vis;
    boolean[] pathVis;
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
       graph = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int []pre : prerequisites){
            int a = pre[0];
            int b = pre[1];
            graph[b].add(a);
        }


        vis = new boolean[numCourses];
        pathVis = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                dfs(i);
            }
        }

        if(hasCycle) return false;
    return true;
    }

    void dfs(int curr){
        if(hasCycle) return;

        vis[curr] = true;
        pathVis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            if(!vis[graph[curr].get(i)]){
                dfs(graph[curr].get(i));
            }else if(pathVis[graph[curr].get(i)]){
                hasCycle = true;
                return;
            }
        }
        pathVis[curr] = false;
    }
}