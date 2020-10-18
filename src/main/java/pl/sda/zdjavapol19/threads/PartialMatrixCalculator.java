package pl.sda.zdjavapol19.threads;

import java.time.Duration;
import java.time.Instant;

public class PartialMatrixCalculator extends Thread {

    final int[][] matrix;
    final int xStart;
    final int xEnd; //exclusive
    long sum = 0;
    long calcTimeInMs = 0;

    public PartialMatrixCalculator(int[][] matrix, int xStart, int xEnd) {
        this.matrix = matrix;
        this.xStart = xStart;
        this.xEnd = xEnd;
    }

    @Override
    public void run() {
        Instant start = Instant.now();

        for(int x = xStart; x < xEnd; x++) {
            for(int y = 0; y < matrix[0].length; y++) {
                sum += matrix[x][y];
            }
        }

        Instant end = Instant.now();
        calcTimeInMs = Duration.between(start, end).toMillis();
        System.out.printf("Suma elementow macierzy w zakresie (%d, %d) wynosi %d.\n" +
                        "Czas obliczen tego watku wyniosl %sms\n",
                        xStart, xEnd, sum, calcTimeInMs);
    }

    public long getSum() {
        return sum;
    }

    public long getCalcTimeInMs() {
        return calcTimeInMs;
    }

    @Override
    public String toString() {
        return "PartialMatrixCalculator{" +
                ", xStart=" + xStart +
                ", xEnd=" + xEnd +
                ", sum=" + sum +
                ", calcTimeInMs=" + calcTimeInMs +
                '}';
    }
}
