class Solution {
    private int[][] matrix;
    public int[][] generateMatrix(int n) {
        this.matrix = new int[n][n];

    return this.matrix;
    }

    private int fillMatrix(int size, int n) {
        if (size == 1) {
            size /= 2;
            matrix[size][size] = n;
            return 3;
        }
        if (size == 2) {

        }
        size = fillMatrix(size - 2, n);
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = solution.generateMatrix(3);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j] + ", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
