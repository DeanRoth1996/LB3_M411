/**
 * Klasse mit Sortieralgorithmus zur
 * Sortierung von Zahlenarrays
 *
 * Stabil: ja
 *
 * Worst-Case: О(n^2)
 * Average-Case: O(n^2)
 * Best-Case: 0(n)
 *
 * @Author Dean Roth
 * @Version 1.0
 * @Date 28.01.2021
 */
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

public class gnomeSort {
    double startTime;
    double endTime;
    double finalTime;
    double memory = 0;
    int loopCounter;


    /**
     *
     * @return
     */
    public double getStartTime() {
        return startTime;
    }

    public void setStartTime() {
        startTime = new Date().getTime();
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime() {
        endTime = new Date().getTime();
        setFinalTime();
    }

    public void setFinalTime() {
        finalTime = endTime - startTime;
    }

    public double getFinalTime() {
        return finalTime;
    }

    public int getLoopCounter() {
        return loopCounter;
    }

    public void plusLoopCounter() {
        this.loopCounter++;
    }


    /**
     * Was macht es
     *
     * @param arr
     * @param n
     */
    public void gnomeSort(int arr[], int n) {
        setStartTime();
        int index = 0;

        while (index < n) {
            plusLoopCounter();
            if (index == 0)
            index++;
            if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                int temp = 0;
                temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }

        setEndTime();
        Runtime rt = Runtime.getRuntime();
        memory = rt.totalMemory() - rt.freeMemory();
        return;

    }

    /**
    public static void main(String[] args) {
        int arr[] = {34, 2, 10, -9};

        gnomeSort gs = new gnomeSort();

        gs.gnomeSort(arr, arr.length);

        System.out.print("Sorted sequence after applying Gnome sort: ");
        System.out.println(Arrays.toString(arr));
        System.out.println(gs.getFinalTime() + " ms");
        System.out.println(gs.getLoopCounter() + " loops");
        System.out.println(gs.getIterrationCounter() + " iterrations");
    }**/
}