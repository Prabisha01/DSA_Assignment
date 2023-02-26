package QuestionSeven;//Question no 7a
//The program first initializes two matrices a and b of size n x n with random integer values between 0 and 4.
// It then creates an empty matrix result of size n x n, which will store the result of the matrix multiplication.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int n = 5; //size
        int[][] a = new int[n][n]; //array a for 2D matrix
        int[][] b = new int[n][n];//array b for 4D matrix
        int[][] result = new int[n][n];// storing the result


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (int) (Math.random() * 5); //creating randoms
                b[i][j] = (int) (Math.random() * 5);
            }
        }

        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads); // manages a fixed pool of threads

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Runnable task = new Task(a, b, result, i, j);
                executor.execute(task);
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Task implements Runnable { //multithread
        int[][] a;
        int[][] b;
        int[][] result;
        int i;
        int j;

        public Task(int[][] a, int[][] b, int[][] result, int i, int j) { //constructor
            this.a = a;
            this.b = b;
            this.result = result;
            this.i = i;
            this.j = j;
        }

        public void run() { //method run to return the sum
            int sum = 0;
            for (int k = 0; k < a.length; k++) {
                sum += a[i][k] * b[k][j];
            }
            result[i][j] = sum;
        }
    }
}
