package pl.sda.zdjavapol19.threads;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class MatrixRunner {

    public static void main(String[] args) {
        int[][] matrix = createMatrix(10000, 10000, 2);
        int[][] smallMatrix = createMatrix(1000, 1000, 2);

        calcMatrixSingleThread(matrix);
        calcMatrixMultipleThreads(matrix, 2);
    }

    static void calcMatrixMultipleThreads(final int[][] matrix, int threads) {
        PartialMatrixCalculator[] partialMatrixCalculators = new PartialMatrixCalculator[threads];
        //1000
        //1000/4=250
        //0, 250
        //250, 500
        //500, 750
        //750, 1000
        final int matrixColumnChunk = matrix.length/threads;
        for(int it = 0; it < threads; it++)
            partialMatrixCalculators[it] = new PartialMatrixCalculator
                    (matrix, it * matrixColumnChunk, (it+1) * matrixColumnChunk);

        for(PartialMatrixCalculator pmc : partialMatrixCalculators)
            pmc.start();

        /*long wholeMatrixSum = 0;
        long calcTime = 0;  //max wartosc z pmc.calcTime
        for(PartialMatrixCalculator pmc : partialMatrixCalculators) {
            wholeMatrixSum += pmc.sum;
        }

        System.out.printf("Suma elementow macierzy wynosi %d.\n" +
                          "Czas obliczen dla %d watkow wyniosl %sms\n",
                wholeMatrixSum, threads, calcTime);*/
    }

    static void calcMatrixSingleThread(final int[][] matrix) {
        Instant start = Instant.now();
        long sum = 0;

        for(int x = 0; x < matrix.length; x++) {
            for(int y = 0; y < matrix[0].length; y++) {
                sum += matrix[x][y];
            }
        }

        Instant end = Instant.now();
        System.out.printf("Suma elementow macierzy wynosi %d.\n" +
                "Czas obliczen na pojedynczym watku wyniosl %sms\n",
                sum, Duration.between(start, end).toMillis());
    }

    static int[][] createMatrix(int columns, int rows, int maxValue) {
        int[][] matrix = new int[columns][rows];
        for(int x = 0; x < columns; x++) {
            for(int y = 0; y < rows; y++) {
                matrix[x][y] = ThreadLocalRandom.current().nextInt(maxValue);
            }
        }
        return matrix;
    }

}
