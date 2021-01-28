/**
 * Klasse mit Sortieralgorithmus zur
 * Sortierung von Zahlenarrays, nach
 * dem Schema des Quick Sorts.
 *
 * Quelle: Wikipedia
 *
 * <p>
 * Stabil: ja
 * <p>
 * Worst-Case: O(n^2)
 * Average-Case: O(n*log(n))
 * Best-Case: O(n*log(n))
 *
 * @Author Skyelar Maurer
 * @Version 1.0
 * @Date 28.01.2021
 */
public class QuickSort {

    private double comparisons = 0;
    private double loops = 0;
    private double time;
    private double memory;

    /**
     * Diese Funktion implementiert den Quick Sort Rekurrsiv
     *
     * @param array unsortiertes array aus Zahlen
     * @param low kleinster möglicher Index des Arrays
     * @param high grösster möglicher Index des Arrays
     * @return sortiertes Array aus Zahlen
     */
    public int[] sort(int[] array, int low, int high) {
        if (low < high) {
            loops++;
            /* pi is partitioning index, array[pi] is
              now at right place */
            int pi = partition(array, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(array, low, pi - 1);
            sort(array, pi + 1, high);
        }
        Runtime rt = Runtime.getRuntime();
        memory = rt.totalMemory() - rt.freeMemory();
        return array;
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                comparisons++;
                i++;

                // swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
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
    public Double getTime() {
        return null;
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
