import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    //time memory comparinsons loopos

    private static Map<String, Map<String, Long>> tenInts_measurements;
    private static Map<String, Map<String, Long>> hundredInts_measurements;
    private static Map<String, Map<String, Long>> thousandInts_measurements;


    public static void main(String[] args) {
        int[] tenInts = readFile("./ressources/10Digits.txt", new int[10]);
        int[] hundredInts = readFile("./ressources/100Digits.txt", new int[100]);
        int[] thousandInts = readFile("./ressources/1000Digits.txt", new int[1000]);

        int[] tenSortedInts = getSortedIntsAndMeasurements(tenInts,10);
        int[] hundredSortedInts = getSortedIntsAndMeasurements(hundredInts,100);
        int[] thousandSortedInts = getSortedIntsAndMeasurements(thousandInts,1000);

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

    private static int[] getSortedIntsAndMeasurements(int[] unsortedIntsArray, int howManyIntsInArray) {
        SwapSorter swapSort = new SwapSorter();
        Insertionsort insertionSort = new Insertionsort();
        MergeSort mergeSort = new MergeSort();
        BubbleSort bubbleSort = new BubbleSort();
        QuickSort quickSort = new QuickSort();

        int[] sortedInts = insertionSort.sort(unsortedIntsArray);
        swapSort.sort(unsortedIntsArray);
        //mergeSort.sort(unsortedIntsArray);
        bubbleSort.sort(unsortedIntsArray);
        quickSort.sort(unsortedIntsArray,1,100);

        putMeasurementsMapInMap(howManyIntsInArray,swapSort,insertionSort,mergeSort,bubbleSort,quickSort);

        return sortedInts;
    }

    private static void putMeasurementsMapInMap(int howManyIntsInArray, SwapSorter swapSort, Insertionsort insertionSort, MergeSort mergeSort, BubbleSort bubbleSort, QuickSort quickSort){
        Map<String, Map<String, Long>> mapOfAllMeasurements = new HashMap<>();

        Map<String, Long> swap_measurements = putMeasurementsInMap(swapSort.getTime(), swapSort.getMemory(), Long.valueOf(swapSort.getSwaps()),Long.valueOf(swapSort.getLoops()));;
        Map<String, Long> insertion_measurements = putMeasurementsInMap(insertionSort.getTime,insertionSort.getMemory, insertionSort.getComparisons, insertionSort.getLoopPasses());
        Map<String, Long> merge_measurements = putMeasurementsInMap(mergeSort.getTime, mergeSort.getMemory, mergeSort.getComparisons, mergeSort.getLoops);
        Map<String, Long> bubble_measurements = putMeasurementsInMap(bubbleSort.getTime, bubbleSort.getMemory,bubbleSort.getComparisons, bubbleSort.getLoops);
        Map<String, Long> quick_measurements = putMeasurementsInMap( quickSort.getTime,quickSort.getMemory,quickSort.getComparisons,quickSort.getLoops);

        mapOfAllMeasurements.put("swap", swap_measurements);
        mapOfAllMeasurements.put("insertion", insertion_measurements);
        mapOfAllMeasurements.put("merge", merge_measurements);
        mapOfAllMeasurements.put("bubble", bubble_measurements);
        mapOfAllMeasurements.put("quick", quick_measurements);

        switch (howManyIntsInArray) {
            case 10:
                tenInts_measurements = mapOfAllMeasurements;
                break;
            case 100:
                hundredInts_measurements = mapOfAllMeasurements;
                break;
            case 1000:
                thousandInts_measurements = mapOfAllMeasurements;
                break;
        }
    }

    private static Map<String, Long> putMeasurementsInMap(Long time, Long memory, Long comparisons, Long loops){
        Map<String, Long> measurements = new HashMap<>();

        measurements.put("time", time);
        measurements.put("memory", memory);
        measurements.put("comparisons", comparisons);
        measurements.put("loops", loops);

        return measurements;
    }
}

