/**
 * Klasse mit Sortieralgorithmus zur
 * Sortierung von Zahlenarrays
 *
 * Stabil: ja
 *
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
     * @Attribute Zählervariable für Schleifendurchgänge
     */
    private int loopPasses = 0;

    /**
     * Sortiermethode sort()
     * @param array int[] unsortiert
     * @return array int[] sortiert
     */
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
        return zahlenArray;
    }

    /**
     * get-Methode von Schleifendurchgängen
     * @return Zählervariable loopPasses
     */
    public int getLoopPasses() {
        return loopPasses;
    }

}
