import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

/**
 * Klasse mit Sortieralgorithmus zur
 * Sortierung von ZahlenArrays (Swap-Sort)
 * <p>
 * Stabil: ja
 * <p>
 * Worst-Case: O(n^2)
 * Average-Case: O(n^2)
 * Best-Case: O(n^2)
 *
 * @Author Jahi Yancy
 * @Version 1.0
 * @Date 24.01.2021
 * Quelle: https://de.wikipedia.org/wiki/Swap-Sort
 */

public class SwapSorter {

    int loopPasses = 0;
    int comparisons = 0;
    double memory = 0;
    double time = 0;

    /**
     * @param sortMe
     * @return
     */
    public int[] sort(int[] sortMe) {

        double startTime = new Date().getTime();
        int messArray[] = sortMe;
        int startwert = 0;


        while (startwert < sortMe.length - 1) {

            int kleinere = countSmallerOnes(sortMe, startwert);

            if (kleinere > 0) {
                int tmp = sortMe[startwert];
                sortMe[startwert] = sortMe[startwert + kleinere];
                sortMe[startwert + kleinere] = tmp;

            } else {
                startwert++;

            }
            comparisons++;
            loopPasses++;
        }

        time = new Date().getTime() - startTime;
        Runtime rt = Runtime.getRuntime();
        memory = rt.totalMemory() - rt.freeMemory();

        return messArray;
    }

    /**
     * @param countHere
     * @param index
     * @return
     */
    private int countSmallerOnes(final int[] countHere, final int index) {
        int counter = 0;

        for (int i = index + 1; i < countHere.length; i++) {
            comparisons++;
            if (countHere[index] > countHere[i]) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * get-Methode der Anzahl Schleifendurchgängen
     *
     * @return Zählervariable loopPasses
     */
    public int getLoops() {
        return loopPasses;
    }

    /**
     * get-Methode der Anzahl Vergleiche
     *
     * @return Zählervariable comparisons
     */
    public int getComparisons() {
        return comparisons;
    }

    /**
     * get-Methode der Zeit
     *
     * @return benötigte Zeit der Sortierung in ms
     */
    public double getTime() {
        return time;
    }

    /**
     * get-Methode des Speichers
     *
     * @return Speicherbedarf der
     */
    public double getMemory() {
        return memory;
    }

}