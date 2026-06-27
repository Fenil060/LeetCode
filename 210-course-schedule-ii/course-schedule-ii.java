class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        int []indeg = new int[numCourses];

        for(int []pre : prerequisites){
            int a = pre[0];
            int b = pre[1];
            graph[b].add(a); //b -> a
            indeg[a]++; 
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()){
            int curr = q.remove();
            ans[idx++] = curr;

            for(int i=0; i<graph[curr].size(); i++){
                indeg[graph[curr].get(i)]--;
                if(indeg[graph[curr].get(i)] == 0){
                    q.add(graph[curr].get(i));
                }
            }          
        }
        
        if(idx < numCourses) {
            return new int[0]; // cycle exists
        }
        return ans;
    }
}