/* 
Approach: as we want to recolor all the connected pixels that have same color
As we already have four directions, it looks like graph traversal problem
Hence we can use depth-first-search, since we have all connected components here
*/  

// Time : O(mxn) --> in worst case scenario every pixel in the image visited only once
// Space : O(mxn) --> as recursion stack in the worst case (entire grid filled with the same color).

// Yes the code successfully ran over leetcode.

class Solution {
    int[][] dirs;
    int m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        this.m = image.length;
        this.n = image[0].length;

        int oldColor = image[sr][sc]; // store original color of start pixel
        if(oldColor == color) return image; // check if the original color is equal to already new color

        dfs(image, sr, sc, color, oldColor); // perform dfs and recolor the current pixel

        return image;

    }

    private void dfs(int[][] image, int i, int j, int color, int oldColor) {

        if(i < 0 || j < 0 || i == m || j == n || image[i][j] != oldColor) return;

        image[i][j] = color; // recolor the current pixel

        for(int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;

            {dfs(image, r, c, color, oldColor);} // recursively call dfs to check all connected components
        }
    }
}