import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private int[][] m;
    private List<Integer> temp;

    public int[][] diagonalSort(int[][] mat) {
        m = new int[mat.length][mat[0].length];
        temp = new ArrayList<>(mat.length);

        for (int i = mat.length-1; i >= 0 ; i--) {
            for (int j = 0, ij = i; j < mat[0].length && ij < mat.length; j++, ij++) {
                temp.add(mat[ij][j]);
            }
            filDiagonal(i, -1);
            temp.clear();
        }


        for (int j = 1; j < mat[0].length ; j++) {
            for (int i = 0, ji = j; i < mat.length && ji < mat[i].length; i++, ji++) {
                temp.add(mat[i][ji]);
            }
            filDiagonal(-1, j);
            temp.clear();
        }
        return m;
    }

    private void filDiagonal(int column, int row) {
        Collections.sort(temp);
        if (column != -1) {
            for (int j = 0, ij = column; j < m[0].length && ij < m.length; j++, ij++) {
                m[ij][j] = temp.get(j);
            }
        }
        if (row != -1) {
            for (int i = 0, ji = row; i < m.length && ji < m[i].length; i++, ji++) {
                m[i][ji] = temp.get(i);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printMatrix(solution.diagonalSort(new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}}));

    }

    private static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//    A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction
//    until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1],
//    and mat[4][2].
//
//        Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
//
//
//
//        Example 1:
//
//
//        Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
//        Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
//        Example 2:
//
//        Input: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
//        Output: [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
//
//
//        Constraints:
//
//        m == mat.length
//        n == mat[i].length
//        1 <= m, n <= 100
//        1 <= mat[i][j] <= 100