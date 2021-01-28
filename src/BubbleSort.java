import java.time.Duration;
import java.time.Instant;

public class BubbleSort {

    private double comparisons = 0;
    private double loops = 0;
    private double time;
    private double memory;

    public int[] sort(int[] array) {
        Instant start = Instant.now();
        int n = array.length;
        for (int i = 0; i < n - 1; i++){
            loops++;
            for (int j = 0; j < n - i - 1; j++){
                if (array[j] > array[j + 1]) {
                    comparisons++;
                    // swap array[j+1] and array[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        Runtime rt = Runtime.getRuntime();
        memory = rt.totalMemory() - rt.freeMemory();
        Instant end = Instant.now();
        time = Duration.between(start, end).toMillis();
        return array;
    }


    public double getComparisons() {
        return comparisons;
    }

    public double getLoops() {
        return loops;
    }

    public double getTime() {
        return time;
    }

    public double getMemory() {
        return memory;
    }
}
