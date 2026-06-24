class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;

        boolean [][]vis = new boolean[row][col];
        int currColor = image[sr][sc];
        if (currColor == color) return image;

        floodfill(image, sr, sc, color, vis, currColor);
    return image;
    }

    public void floodfill(int[][] image, int r, int c, int color, boolean [][]vis, int currcolor){
        int row = image.length;
        int col = image[0].length;

        int []dr = {-1, 0, 1, 0}; // t r b l
        int []dc = {0, 1, 0, -1};

        if(r < 0 || r >= row || c < 0 || c >= col || vis[r][c] == true || image[r][c] != currcolor){
            return;
        }

        vis[r][c] = true;
        image[r][c] = color;

        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            floodfill(image, nr, nc, color, vis, currcolor);
        }
    }
}