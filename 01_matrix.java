/*
Approach 01: Since we have connected components or neighbours to explore
here we can use BFS with queue approach.

For Brute Force we can do BFS for each and every cell or bucket

Time: m sqr n sqr(not optimal) --> time limit exceeded
Space: mxn

To Optimize this:
Instead of starting from 1's we can start from 0's
so we need not to repeat BFS and we can compute all ans together.
 */

// Time: O(mxn)
// Space: O(mxn)

// Code works fine over leetcode


class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;          
        int n = mat[0].length;       

        Queue<int[]> q = new LinkedList<>();  // queue for BFS
        boolean[][] visited = new boolean[m][n];  // track processed cells

        // Push all 0 cells into queue 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});   // source cell
                    visited[i][j] = true;       // mark visited immediately
                }
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}}; 

        // BFS traversal
        while (!q.isEmpty()) {

            int[] curr = q.poll();  
            int r = curr[0];
            int c = curr[1];

            // Explore all 4 neighbours
            for (int[] d : dirs) {

                int nr = r + d[0];   
                int nc = c + d[1];  

                // Check boundary and ensure not already visited
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc]) {

                    mat[nr][nc] = mat[r][c] + 1;  // distance 
                    visited[nr][nc] = true;       
                    q.offer(new int[]{nr, nc});   // push neighbor into queue
                }
            }
        }

        return mat;   
    }
}