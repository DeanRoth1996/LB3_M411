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
    /**
     * @Attribute Start- und Endzeit, Zählervariable für Schleifendurchgänge, memory für Speicher
     */

    double startTime;
    double endTime;
    double finalTime;
    double memory = 0;
    int loopCounter;

    /**
     *
     * @return Startzeit
     */
    public double getStartTime() {
        return startTime;
    }

    /**
     * set-Methode für Startzeit
     */
    public void setStartTime() {
        startTime = new Date().getTime();
    }

    /**
     *
     * @return Endzeit
     */
    public double getEndTime() {
        return endTime;
    }

    /**
     * set-Methode für Endzeit
     */
    public void setEndTime() {
        endTime = new Date().getTime();
        setFinalTime();
    }

    /**
     * set-Methode für finale Zeit
     */
    public void setFinalTime() {
        finalTime = endTime - startTime;
    }

    /**
     * get-Methode der Zeit
     * @return benötigte Zeit der Sortierung in ms
     */
    public double getFinalTime() {
        return finalTime;
    }
    /**
     * get-Methode der Anzahl Schleifendurchgängen
     * @return Zählervariable loopPasses
     */

    /**
     * @return Schleifenzähler
     */
    public int getLoopCounter() {
        return loopCounter;
    }

    /**
     * Loopcounter erhöhen
     */
    public void plusLoopCounter() {
        this.loopCounter++;
    }

    /**
     * get-Methode des Speichers
     * @return Speicherbedarf der
     */
    public double getMemory(){
        return memory;}


    /**
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