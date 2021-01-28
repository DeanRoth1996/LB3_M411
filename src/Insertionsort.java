import java.time.Duration;
import java.time.Instant;

/**
 * Klasse mit Sortieralgorithmus zur
 * Sortierung von Zahlenarrays
 * <p>
 * Stabil: ja
 * <p>
 * Worst-Case: О(n)
 * Average-Case: O(n^2)
 * Best-Case: O(n log n)
 *
 * @Author Nikola Aleksic
 * @Version 1.0
 * @Date 28.01.2021
 */
public class Insertionsort {
    /**
     * @Attribute Zählervariable für Schleifendurchgänge, memory für Speicher
     */
    private int loopPasses = 0;
    long memory = 0;
    /**
     * Sortiermethode sort()
     *
     * @param array int[] unsortiert
     * @return array int[] sortiert
     */
    Instant start = Instant.now();
    public int[] sort(int[] array) {

        int[] zahlenArray = array;
        int n = zahlenArray.length;
        for (int i = 1; i < n; ++i) {
            loopPasses++;
            int key = zahlenArray[i];
            int j = i - 1;

            while (j >= 0 && zahlenArray[j] > key) {
                zahlenArray[j + 1] = zahlenArray[j];
                j = j - 1;
            }
            zahlenArray[j + 1] = key;
        }
        Runtime rt = Runtime.getRuntime();
        memory = rt.totalMemory() - rt.freeMemory();
        return zahlenArray;
    }
    Instant finish = Instant.now();
    long time = Duration.between(start, finish).toMillis();  //in millis

    /**
     * get-Methode von Schleifendurchgängen
     *
     * @return Zählervariable loopPasses
     */
    public int getLoopPasses() {
        return loopPasses;
    }

    public long getTime() {
        return time;
    }
}
