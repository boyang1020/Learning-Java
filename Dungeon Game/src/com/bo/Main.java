import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/*
Dungeon Game

The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

input
2d Integer array

output
Integer for the minimum initial health


example input
-2 -3 3
-5 -10 1
10 30 -5
example output
7
 */

public class Main {



    static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        //init dp table
        int[][] h = new int[m][n];

        h[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        //init last row
        for (int i = m - 2; i >= 0; i--) {
            h[i][n - 1] = Math.max(h[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        //init last column
        for (int j = n - 2; j >= 0; j--) {
            h[m - 1][j] = Math.max(h[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        //calculate dp table
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(h[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(h[i][j + 1] - dungeon[i][j], 1);
                h[i][j] = Math.min(right, down);
            }
        }

        return h[0][0];

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _dungeon_rows = 0;
        int _dungeon_cols = 0;
        _dungeon_rows = Integer.parseInt(in.nextLine().trim());
        _dungeon_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _dungeon = new int[_dungeon_rows][_dungeon_cols];
        for(int _dungeon_i=0; _dungeon_i<_dungeon_rows; _dungeon_i++) {
            for(int _dungeon_j=0; _dungeon_j<_dungeon_cols; _dungeon_j++) {
                _dungeon[_dungeon_i][_dungeon_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = calculateMinimumHP(_dungeon);
        System.out.println(String.valueOf(res));

    }
}
