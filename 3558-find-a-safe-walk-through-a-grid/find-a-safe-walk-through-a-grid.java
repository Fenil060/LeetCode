class Solution {
    int[][] maxHealth;

    static class Pair {
        int r;
        int c;
        int h;

        public Pair(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    int dr[] = { -1, 0, 1, 0 };
    int dc[] = { 0, 1, 0, -1 };

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        maxHealth = new int[n][m];

        for(int []r : maxHealth){
            Arrays.fill(r, -1);
        }

        Queue<Pair> q = new LinkedList<>();
        maxHealth[0][0] = health-grid.get(0).get(0);
        q.add(new Pair(0, 0, maxHealth[0][0]));

        while(!q.isEmpty()){
             Pair curr = q.remove();

             if(curr.h <= 0) continue;

             if(curr.r == n-1 && curr.c == m-1) return true;

             for(int i=0; i<4; i++){
                int nr = curr.r+dr[i];
                int nc = curr.c+dc[i];
                
                if(nr >=0 && nc >=0 &&nr < n && nc < m){
                    int newHealth = Math.max(maxHealth[nr][nc], curr.h - grid.get(nr).get(nc));

                    if(newHealth > maxHealth[nr][nc]){
                        q.add(new Pair(nr, nc, newHealth));
                         maxHealth[nr][nc] = newHealth;
                    }
                }
             }
        }
    return false;
    }
}