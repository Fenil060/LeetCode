class Solution {
    int dr[] = {-1, 0, 1, 0}; // t r b l
    int dc[] = {0, 1, 0, -1};

    static class Pair{
        int r;
        int c;
        boolean v;

        public Pair(int r, int c, boolean v){
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }

    public void solve(char[][] board) {
        Queue<Pair> q = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][]vis = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    if(board[i][j] == 'O'){
                        vis[i][j] = true;
                        q.add(new Pair(i, j, true));
                    }
                }
            }
        }

        while(!q.isEmpty()){
            Pair curr = q.remove();
            for(int i=0; i<4; i++){
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if(nr >= 0 && nc >= 0 && nr<m && nc<n && !vis[nr][nc] && board[nr][nc] == 'O'){
                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc, true));
    
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }
    }
}