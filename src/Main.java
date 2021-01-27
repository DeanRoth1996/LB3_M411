import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    //time memory comparinsons loopos

    private Map<String, Map<String, Float>> tenInts_measurements;
    private Map<String, Map<String, Float>> hundredInts_measurements;
    private Map<String, Map<String, Float>> thousandInts_measurements;


    public static void main(String[] args) {
        int[] tenInts = readFile("./ressources/10Digits.txt", new int[10]);
        int[] hundredInts = readFile("./ressources/100Digits.txt", new int[100]);
        int[] thousandInts = readFile("./ressources/1000Digits.txt", new int[1000]);

    }

    private static int[] readFile(String path, int[] array) {
        int index = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\\s+", "");      //removes all whitespaces from String
                array[index] = Integer.parseInt(line);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    private static Map<String, int[]> sortTenInts(int[] array) {
        Map<String, int[]> sorted_tenInt_arrays = new HashMap<>();

        Map<String, Float> swap_measurements = new HashMap<>();
        Map<String, Float> insertion_measurements = new HashMap<>();
        Map<String, Float> merge_measurements = new HashMap<>();

        SwapSorter swapSort = new SwapSorter();
        Insertionsort insertionSort = new Insertionsort();
        MergeSort mergeSort = new MergeSort();

        sorted_tenInt_arrays.put("swap", swapSort.sort(array));
        sorted_tenInt_arrays.put("insert", insertionSort.sort(array));
        //sorted_tenInt_arrays.put("merge", mergeSort.***)

        swap_measurements.put("time", swapSort.getTime);
        swap_measurements.put("memory", swapSort.getMemory);
        swap_measurements.put("comparisons", swapSort.getComparisons);
        swap_measurements.put("loops", swapSort.getLoops);

        insertion_measurements.put("time", insertionSort.getTime);
        insertion_measurements.put("memory", insertionSort.getMemory);
        insertion_measurements.put("comparisons", insertionSort.getComparisons);
        insertion_measurements.put("loops", insertionSort.getLoops());




    }
}

