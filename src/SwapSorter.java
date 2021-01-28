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



    int loopPasses = 0;
    int comparisons = 0;
    double memory = 0;
    double time=0;


    public int[] sort(int[] sortMe) {

        long startTime = new Date().getTime();
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
            comparisons++;
            loopPasses++;
        }

        time = new Date().getTime()-startTime;
        Runtime rt = Runtime.getRuntime();
        memory = rt.totalMemory() - rt.freeMemory();

        return messArray;
    }

    private int countSmallerOnes(final int[] countHere, final int index) {
        int counter = 0;

        for (int i = index + 1; i < countHere.length; i++) {
            if (countHere[index] > countHere[i]) {
                counter++;
            }
            comparisons++;

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
     * get-Methode der Anzahl Vergleiche
     * @return Zählervariable comparisons
     */
    public int getComparisons() {return comparisons;
    }
    /**
     * get-Methode der Zeit
     * @return benötigte Zeit der Sortierung in ms
     */
    public double getTime(){return time;}
    /**
     * get-Methode des Speichers
     * @return Speicherbedarf der
     */
    public double getMemory(){return memory;}

/*
    public static void main(String[] args) {
        SwapSorter swapSorter = new SwapSorter();

        int[] myNum =  {7,8,5,2,4,9,3,1} ;

        System.out.println("not sorted: ");
        for (int i = 0; i < myNum.length; i++) {
            System.out.print(myNum[i] + " ");
        }
        swapSorter.sort(myNum);



        int loopPasses = swapSorter.getLoops();
        int comparisons = swapSorter.getComparisons();
        double time = swapSorter.getTime();
        double memory = swapSorter.getMemory();

        System.out.println();
        System.out.println();
        System.out.println("sorted: ");

        for (int i = 0; i < myNum.length; i++) {
            System.out.print(myNum[i] + " ");
        }


        System.out.println();
        System.out.println();
        System.out.println("Looppasses: " + loopPasses);
        System.out.println("comparisons: " + comparisons);
        System.out.println("Time: " + time + "ms");
        System.out.println("Memory: " + memory + " Bytes");

    }*/
}