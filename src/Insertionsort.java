import java.time.Duration;
import java.time.Instant;

/**
 * Klasse mit Sortieralgorithmus zur
 * Sortierung von Zahlenarrays "Insertionsort"
 *
 * Stabil: ja
 *
 * Worst-Case: О(n)
 * Average-Case: O(n^2)
 * Best-Case: O(n log n)
 *
 * Quellen: https://de.wikipedia.org/wiki/Insertionsort
 *          https://www.geeksforgeeks.org/insertion-sort/
 *
 * @Author Nikola Aleksic
 * @Version 1.0
 * @Date 28.01.2021
 */
public class Insertionsort {
    /**
     * @Attribute Zählervariable für Schleifendurchgänge, memory für Speicher
     */
    double loopPasses = 0;
    double memory = 0;
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
    double time = Duration.between(start, finish).toMillis();  //in millis

    /**
     * get-Methode von Schleifendurchgängen
     *
     * @return Zählervariable loopPasses
     */
    public double getLoops() {
        return loopPasses;
    }

    public double getTime() {
        return time;
    }

    public double getMemory() {
        return memory;
    }

    public Double getComparisons() {
        return null;
    }
}
