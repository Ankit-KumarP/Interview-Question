// (15/01/2024, 8:25AM) | Bently Systems
// Given a m x n grid filled with non-negative numbers, find a path from top left (0,0) to bottom right(n-1,n-1), which minimizes the sum of all numbers along its path, and return the maximum value in the optimal path.
// Note: You can only move either down or right at any point in time.
// Example 1:
// Input: grid = [[1,3,1],
// 		[1,5,1],
// 		[4,2,1],
// Output: 3
// Explanation:  The optimal path is  1 → 3 → 1 → 1 → 1.
// Maximum value in optimal path is 3.

package My_Interview_Ques;

public class Q02MaxValueInOptimal {
    // LOGIC
    // (I) for each grid[i][j] calculate the minimum cost to come their by checking
    // all the possible path avalible.
    // (II) NOTE : Above approach is diffrent from direcly choosing chossing optimal
    // path(greedly) from starting.

    // function
    public static int maxValue(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int matrix[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = grid[i][j];
            }
        }

        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i] + grid[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i - 1][j] >= grid[i][j - 1]) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }
            }
        }

        int rtn = matrix[m - 1][n - 1];
        int ptr1 = m - 1, ptr2 = n - 1;
        while (ptr1 > 0 || ptr2 > 0) {
            int first = Integer.MAX_VALUE;
            if (ptr1 - 1 >= 0 && ptr2 >= 0) {
                first = grid[ptr1 - 1][ptr2];
            }
            int second = Integer.MAX_VALUE;
            if (ptr1 >= 0 && ptr2 - 1 >= 0) {
                second = grid[ptr1][ptr2 - 1];
            }
            if (first >= second) {
                ptr2--;
                rtn = Math.max(rtn, matrix[ptr1][ptr2]);
            } else {
                ptr1--;
                rtn = Math.max(rtn, matrix[ptr1][ptr2]);
            }
        }

        return rtn;

    }

    public static void main(String[] args) {
        // int[][] grid = {
        // { 1, 3, 1 },
        // { 1, 5, 1 },
        // { 4, 2, 1 }
        // }; // 3

        // int [][] grid = {
        // {3,7},
        // {9,8}
        // }; // 8

        // int [][] grid = {
        // {1,2},
        // {3,5}
        // }; //5

        // int [] [] grid = {
        // {5,9,6},
        // {11,5,2}
        // }; // 9

        int grid[][] = {
                { 11, 2, 3 },
                { 4, 5, 9 },
                { 7, 5, 9 }
        }; // 11

        int ans = maxValue(grid);
        System.out.println(ans);
    }
}
