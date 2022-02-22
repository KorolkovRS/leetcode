class Solution {
    private int[][] matrix;
    private int count;
//    public int[][] generateMatrix(int n) {
//        this.matrix = new int[n][n];
//        count = n*n;
//        fillMatrix(n);
//    return this.matrix;
//    }

    public int[][] generateMatrix(int n) {
        this.matrix = new int[n][n];
        int size = matrix.length;
        int offset = 0;
        int max = n*n;

        while (count < max) {
            for (int j = 0+offset; j < size-offset; j++) {
                matrix[offset][j] = ++count;
            }
            for (int i = 1+offset; i < size-offset; i++) {
                matrix[i][size - 1 - offset] = ++count;
            }
            for (int j = size - 2-offset; j >= offset; j--) {
                matrix[size - 1-offset][j] = ++count;
            }
            for (int i = size - 2-offset; i >= 1+offset; i--) {
                matrix[i][offset] = ++count;
            }
            offset++;
        }
        return this.matrix;
    }

//    private int fillMatrix(int size) {
//        if (size == 1) {
//            size = matrix.length / 2;
//            matrix[size][size] = count;
//            count--;
//            return 3;
//        }
//        if (size == 2) {
//            size = matrix.length / 2 - 1;
//            matrix[size + 1][size] = count--;
//            matrix[size + 1][size + 1] = count--;
//            matrix[size][size + 1] = count--;
//            matrix[size][size] = count--;
//            return 4;
//        }
//        fillMatrix(size - 2);
//        printMatrix();
//        fillBorders(size);
//        return 0;
//    }
//
//    private void fillBorders(int size) {
//        int offset = (matrix.length-size)/2 ;
//        for (int i = 1+offset; i < size+offset; i++) {
//            matrix[i][offset] = count--;
//        }
//        for (int j = 1+offset; j < size+offset; j++) {
//            matrix[size-1+offset][j] = count--;
//        }
//        for (int i = size-2+offset; i >= offset; i--) {
//            matrix[i][size-1+offset] = count--;
//        }
//        for (int j = size-2+offset; j >= offset; j--) {
//            matrix[0+offset][j] = count--;
//        }
//    }

        public void printMatrix () {
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

        public static void main (String[]args){
            Solution solution = new Solution();
            int[][] matrix = solution.generateMatrix(4);
            solution.printMatrix();
        }
    }
