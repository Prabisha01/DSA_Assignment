package QuestionEight;
//This program uses dynamic programming to find the maximum area of a square that can be formed by the number
//        0 in a given 2D matrix. It initializes a new 2D array with the same dimensions as the input matrix and
//        iterates through each element of the input matrix to populate the corresponding element of the new array.
//        The program then returns the square of the maximum value in the new array as the final output.
public class Main {
    public static int maxSquareArea(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] aux = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    aux[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    aux[i][j] = Math.min(aux[i-1][j], Math.min(aux[i][j-1], aux[i-1][j-1])) + 1;
                }
                maxArea = Math.max(maxArea, aux[i][j]);
            }
        }
        return maxArea * maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 0, 1, 1}};
        int maxArea = maxSquareArea(matrix);
        System.out.println("Maximum area of square made by 0s: " + maxArea);
    }

}
