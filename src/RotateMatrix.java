public class RotateMatrix {

    static int[][] rotate(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int[][] newMatrix = new int[col][row];
        for (int r = 0; r < row; r++ ) {
            for (int c = 0; c < col; c++) {
                newMatrix[c][row-r-1] = m[r][c];
            }
        }
        return newMatrix;
    }

    static void rotateMatrix2(int mat[][])
    {
        int N = mat.length;
        // Consider all squares one by one
        for (int x = 0; x < N / 2; x++)
        {
            // Consider elements in group of 4 in
            // current square
            for (int y = x; y < N-x-1; y++)
            {
                // store current cell in temp variable
                int temp = mat[x][y];

                // move values from right to top
                mat[x][y] = mat[y][N-1-x];

                // move values from bottom to right
                mat[y][N-1-x] = mat[N-1-x][N-1-y];

                // move values from left to bottom
                mat[N-1-x][N-1-y] = mat[N-1-y][x];

                // assign temp to left
                mat[N-1-y][x] = temp;
            }
        }
    }

    static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - layer - 1;
            int counter = 0;
            for (int i = first; i < last; i++) {
//                int counter = i - first;
                //top
                int top = matrix[first][first+counter];

                // left > top
                matrix[first][first+counter] = matrix[last-counter][first];

                // bottom > left
                matrix[last-counter][first] = matrix[last][last-counter];

                // right >> bottom
                matrix[last][last-counter] = matrix[first+counter][last];

                // top >> right
                matrix[first+counter][last] = top;

                counter++;
            }
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main (String[] arg) {
        final int[][] matrix = {
                { 1, 2, 3, },
                { 4, 5, 6,},
                { 7, 8, 9,}
        };

        /*
        1r1c = 1r3c
        1r2c = 2r3c
        1r3c = 3r3c
        1r4c = 4r3c

        2r1c = 1r2c
        2r2c = 2r2c
        2r3c = 3r2c
        2r4c = 4r2c
        { 7, 4, 1 }
        { 8, 5, 2 }
        { 9, 6, 3 }
        { -3, -2, -1 }
         */
        rotateMatrix(matrix);
        printMatrix(matrix);
    }
}
