class Solution {
    static class Pair{
        int r,c,t;

        Pair(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int []dr = {-1, 1, 0, 0}; //top bottom left right
        int []dc = {0, 0, -1, 1};

        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;

        for(int r = 0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c] == 2){
                    q.add(new Pair(r, c, 0));
                }
                else if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }
        int time = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            time = p.t;
            for(int i=0; i<4; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                    q.add(new Pair(nr, nc, time+1));
                    grid[nr][nc] = 2;
                    fresh--;
                }
            }
        }
        if(fresh == 0){
            return time;
        }
    return -1;
    }
}