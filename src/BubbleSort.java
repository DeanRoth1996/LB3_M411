import java.time.Duration;
import java.time.Instant;

/**
 * Klasse mit Sortieralgorithmus zur
 * Sortierung von Zahlenarrays, nach
 * dem Schema des Bubble Sorts.
 *
 * Quelle: Wikipedia
 *
 * <p>
 * Stabil: ja
 * <p>
 * Worst-Case: O(n^2)
 * Average-Case: O(n^2)
 * Best-Case: O(n)
 *
 * @Author Skyelar Maurer
 * @Version 1.0
 * @Date 28.01.2021
 */
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


    /**
     * Getter-Methode für die Anzahl
     * Vergleichen
     *
     * @return anzahl Vergleiche
     */
    public double getComparisons() {
        return comparisons;
    }

    /**
     * Getter-Methode für die Anzahl
     * Durchläufe
     *
     * @return anzahl Durchläufe
     */
    public double getLoops() {
        return loops;
    }

    /**
     * Getter-Methode für Zeit in
     * Millisekunden
     *
     * @return Zeit
     */
    public double getTime() {
        return time;
    }

    /**
     * Getter-Methode für den gebrauchten
     * Speicher in Byte
     *
     * @return anzahl Vergleiche
     */
    public double getMemory() {
        return memory;
    }
}
