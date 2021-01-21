public class Insertionsort {

    private int[] sort(int array[]) {

        int zahlenArray[] = array;
        int n = zahlenArray.length;
        for (int i = 1; i < n; ++i) {
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

}
