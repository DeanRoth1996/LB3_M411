/**
 * @author Dean Roth
 * @version 1.0
 * @date 21.01.2021
 */

import java.util.Arrays;
import java.util.Date;

public class gnomeSort {
    private long startTime;
    private long endTime;
    private long finalTime;

    private int loopCounter;
    private int iterrationCounter;

    /**
     *
     * @return
     */
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime() {
        startTime = new Date().getTime();
        ;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime() {
        endTime = new Date().getTime();
        setFinalTime();
    }

    public void setFinalTime() {
        finalTime = endTime - startTime;
    }

    public long getFinalTime() {
        return finalTime;
    }

    public int getLoopCounter() {
        return loopCounter;
    }

    public void plusLoopCounter() {
        this.loopCounter++;
    }

    public int getIterrationCounter() {
        return iterrationCounter;
    }

    public void plusIterrationCounter() {
        this.iterrationCounter++;
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
                plusIterrationCounter();
            index++;
            if (arr[index] >= arr[index - 1]) {
                plusIterrationCounter();
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
        return;
    }

    // Driver program to test above functions. 
    public static void main(String[] args) {
        int arr[] = {34, 2, 10, -9};

        gnomeSort gs = new gnomeSort();

        gs.gnomeSort(arr, arr.length);

        System.out.print("Sorted sequence after applying Gnome sort: ");
        System.out.println(Arrays.toString(arr));
        System.out.println(gs.getFinalTime() + " ms");
        System.out.println(gs.getLoopCounter() + " loops");
        System.out.println(gs.getIterrationCounter() + " iterrations");
    }
}