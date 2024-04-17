// (03/02/2024) 20:03 | JusPay
// QUES:
// Given a 4×4 board with 15 tiles (every tile has one number from 1 to 15) and one empty space. The objective is to place the numbers on tiles in order using the empty space. We can slide four adjacent (left, right, above and below) tiles into the empty space.
// check the puzzel is solvable or not.
package My_Interview_Ques;
// LOGIC:

// (i) Take all the elements of matrix in an array and count number of inversions. [ (2,1) is inversion because 2 > 1 ]
// (I) If 'n' is odd, then puzzel is solvable if number of inversions is even.
// (II) If 'n' is even then solvable if
// (*) inversion count is even and blank is in even position.
// (*) inversion count is odd and blank is in odd position.

public class Q04Puzzels {
    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 9, 1, 15 },
                { 14, 11, 4, 6 },
                { 13, 0, 10, 12 },
                { 2, 7, 8, 5 }
        }; // No

        // int[][] matrix = {
        // { 1,8,2 },
        // { 0,4,3 },
        // { 7,6,5 }
        // }; // Yes

        // int[][] matrix = {
        // { 13,2,10,3 },
        // { 1,12,8,4 },
        // { 5,0,9,6 },
        // { 15,14,11,7 }
        // }; // Yes

        // int[][] matrix = {
        // { 6, 13, 7, 10 },
        // { 8, 9, 11, 0 },
        // { 15, 2, 12, 5 },
        // { 14, 3, 1, 4 }
        // }; // Yes

        int row = matrix.length, col = matrix[0].length;

        int arr[] = new int[row * col - 1];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != 0)
                    arr[index++] = matrix[i][j];
            }
        }

        int inversion_count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    inversion_count++;
                }
            }
        }

        System.out.println("Inversion Count => " + inversion_count);
        int gapIn = gap(matrix, row, col);
        System.out.println("Gap In => " + gapIn);

        if (row % 2 != 0) {
            if (inversion_count % 2 == 0) {
                System.out.println("Yes");
                return;
            } else {
                System.out.println("No");
                return;
            }
        } else if (row % 2 == 0) {
            if (gapIn % 2 == 0) {
                if (inversion_count % 2 == 0) {
                    System.out.println("Yes");
                    return;
                } else {
                    System.out.println("No");
                    return;
                }
            } else {
                if (inversion_count % 2 != 0) {
                    System.out.println("Yes");
                    return;
                } else {
                    System.out.println("No");
                    return;
                }
            }
        }

    }

    // gap
    static int gap(int matrix[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}
