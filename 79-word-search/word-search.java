class Solution {
    int dr[] = {-1, 0, 1, 0}; //top right bottom left
    int dc[] = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
    return false;
    }

    public boolean dfs(char [][]board, String word, int r, int c, int idx){
        if(idx == word.length()) return true;

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(idx)){
            return false;
        }


        //visited
        char temp = board[r][c];
        board[r][c] = '#';

        //recursion
        for(int i=0; i<4; i++){
            int nr = dr[i]+r;
            int nc = dc[i]+c;

            if(dfs(board, word, nr, nc, idx+1)){
                return true;
            }
        }

        //backtrack
        board[r][c] = temp;
    return false;
    }
}
