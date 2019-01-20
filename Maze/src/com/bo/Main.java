package com.bo;

import java.util.ArrayList;

public class Main {
    public static boolean solveMaze(char[][] maze,
                                    int startX, int startY, int targetX, int targetY,
                                    ArrayList<Character> path) {
        if (startX < 0 || startX >= maze.length ||
                startY < 0 || startY >= maze[0].length ||
                maze[startX][startY] == 'X') {
            return false;
        }
        if (startX == targetX && startY == targetY) {
            return true;
        }
        maze[startX][startY] = 'X';
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        char[] direction = {'D', 'R', 'U', 'L'};
        for (int i = 0; i < 4; i++) {
            path.add(direction[i]);
            if (solveMaze(maze, startX+dx[i], startY+dy[i], targetX, targetY, path)) {
                return true;
            }
            path.remove(path.size()-1);
        }
        return false;
    }
}
