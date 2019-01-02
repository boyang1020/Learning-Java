package com.bo;


/*

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 */
public class Main {

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0) return 0;

        final int M = grid.length;
        final int N = grid[0].length;

        boolean visited[][] = new boolean[M][N];

        int islandCount = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, visited, i, j, M, N);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {

        if (!isValid(i, j, m, n) || grid[i][j] != '1' || visited[i][j]) return;

        visited[i][j] = true;

        dfs(grid, visited, i - 1, j, m, n);
        dfs(grid, visited, i + 1, j, m, n);
        dfs(grid, visited, i, j - 1, m, n);
        dfs(grid, visited, i, j + 1, m, n);
    }


    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
