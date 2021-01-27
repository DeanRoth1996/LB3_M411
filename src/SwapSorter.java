import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

/**
 * Klasse mit Sortieralgorithmus zur
 * Sortierung von messArrays
 *
 * Stabil: ja
 *
 * @Author Jahi Yancy
 * @Version 1.0
 * @Date 24.01.2021
 */
public class SwapSorter {

    Instant start = Instant.now();

    int loopPasses = 0;
    int swaps = 0;
    long memory = 0;


    public int[] sort(int[] sortMe) {

        int messArray[] = sortMe;
        int startwert = 0;


        while (startwert < sortMe.length - 1) {

            int kleinere = countSmallerOnes(sortMe, startwert);

            if (kleinere > 0) {
                int tmp = sortMe[startwert];
                sortMe[startwert] = sortMe[startwert + kleinere];
                sortMe[startwert + kleinere] = tmp;

            }
            else
            {
                startwert++;

            }
            swaps++;
            loopPasses++;
        }


        Runtime rt = Runtime.getRuntime();
        memory = rt.totalMemory() - rt.freeMemory();

        return messArray;
    }

    Instant finish = Instant.now();
    long time = Duration.between(start, finish).toMillis();


    private int countSmallerOnes(final int[] countHere, final int index) {
        int counter = 0;

        for (int i = index + 1; i < countHere.length; i++) {
            if (countHere[index] > countHere[i]) {
                counter++;
            }

        }
        return counter;
    }
    /**
     * get-Methode der Anzahl Schleifendurchgängen
     * @return Zählervariable loopPasses
     */
    public int getLoops() {
        return loopPasses;
    }
    /**
     * get-Methode der Anzahl Swaps
     * @return Zählervariable swaps
     */
    public int getSwaps() {return swaps;
    }
    /**
     * get-Methode der Zeit
     * @return benötigte Zeit der Sortierung in ms
     */
    public long getTime(){return time;}
    /**
     * get-Methode des Speichers
     * @return Speicherbedarf der
     */
    public long getMemory(){return memory;}



}