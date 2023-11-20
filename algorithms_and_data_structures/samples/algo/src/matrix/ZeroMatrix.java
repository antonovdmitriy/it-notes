package matrix;

public class ZeroMatrix {

    // Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
    // O(m * n)

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        setZeros(matrix);

        // Print modified matrix
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static void setZeros(int[][] matrix) {

        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroColumns = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroColumns[j] = true;
                }
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroRows[i] || zeroColumns[j]){
                    matrix[i][j] = 0;
                }
            }
        }

        // find a zeros

        // put the zeros

    }
}
