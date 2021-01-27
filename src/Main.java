import java.io.*;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, Map<String, Double>> tenInts_measurements;
    private static Map<String, Map<String, Double>> hundredInts_measurements;
    private static Map<String, Map<String, Double>> thousandInts_measurements;


    public static void main(String[] args) {
        int[] tenInts = readFile("./ressources/10Digits.txt", new int[10]);
        int[] hundredInts = readFile("./ressources/100Digits.txt", new int[100]);
        int[] thousandInts = readFile("./ressources/1000Digits.txt", new int[1000]);

        int[] tenSortedInts = getSortedIntsAndMeasurements(tenInts, HowManyInts.TEN);
        int[] hundredSortedInts = getSortedIntsAndMeasurements(hundredInts, HowManyInts.HUNDRED);
        int[] thousandSortedInts = getSortedIntsAndMeasurements(thousandInts, HowManyInts.THOUSAND);

        printTableWithData(tenSortedInts, HowManyInts.TEN);
        printTableWithData(hundredSortedInts, HowManyInts.HUNDRED);
        printTableWithData(thousandSortedInts, HowManyInts.THOUSAND);

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

    private static int[] getSortedIntsAndMeasurements(int[] unsortedIntsArray, HowManyInts howManyInts) {
        SwapSorter swapSort = new SwapSorter();
        Insertionsort insertionSort = new Insertionsort();
        MergeSort mergeSort = new MergeSort();
        BubbleSort bubbleSort = new BubbleSort();
        QuickSort quickSort = new QuickSort();

        int[] sortedInts = insertionSort.sort(unsortedIntsArray);
        swapSort.sort(unsortedIntsArray);
        //mergeSort.sort(unsortedIntsArray);
        bubbleSort.sort(unsortedIntsArray);
        quickSort.sort(unsortedIntsArray, 1, 100);

        putMeasurementsMapInMap(howManyInts, swapSort, insertionSort, mergeSort, bubbleSort, quickSort);

        return sortedInts;
    }

    private static void putMeasurementsMapInMap(HowManyInts howManyInts, SwapSorter swapSort, Insertionsort insertionSort, MergeSort mergeSort, BubbleSort bubbleSort, QuickSort quickSort) {
        Map<String, Map<String, Double>> mapOfAllMeasurements = new HashMap<>();

        Map<String, Double> swap_measurements = putMeasurementsInMap(swapSort.getTime(), swapSort.getMemory(), Double.valueOf(swapSort.getSwaps()), Double.valueOf(swapSort.getLoops()));
        ;
        Map<String, Double> insertion_measurements = putMeasurementsInMap(insertionSort.getTime, insertionSort.getMemory, insertionSort.getComparisons, insertionSort.getLoopPasses());
        Map<String, Double> merge_measurements = putMeasurementsInMap(mergeSort.getTime, mergeSort.getMemory, mergeSort.getComparisons, mergeSort.getLoops);
        Map<String, Double> bubble_measurements = putMeasurementsInMap(bubbleSort.getTime, bubbleSort.getMemory, bubbleSort.getComparisons, bubbleSort.getLoops);
        Map<String, Double> quick_measurements = putMeasurementsInMap(quickSort.getTime, quickSort.getMemory, quickSort.getComparisons, quickSort.getLoops);

        mapOfAllMeasurements.put("swap", swap_measurements);
        mapOfAllMeasurements.put("insertion", insertion_measurements);
        mapOfAllMeasurements.put("merge", merge_measurements);
        mapOfAllMeasurements.put("bubble", bubble_measurements);
        mapOfAllMeasurements.put("quick", quick_measurements);

        switch (howManyInts) {
            case TEN:
                tenInts_measurements = mapOfAllMeasurements;
                break;
            case HUNDRED:
                hundredInts_measurements = mapOfAllMeasurements;
                break;
            case THOUSAND:
                thousandInts_measurements = mapOfAllMeasurements;
                break;
        }
    }

    private static Map<String, Double> putMeasurementsInMap(Double time, Double memory, Double comparisons, Double loops) {
        Map<String, Double> measurements = new HashMap<>();

        measurements.put("time", time);
        measurements.put("memory", memory);
        measurements.put("comparisons", comparisons);
        measurements.put("loops", loops);

        return measurements;
    }

    private static void printTableWithData(int[] sortedInts, HowManyInts howManyInts){
        switch (howManyInts){
            case TEN:
                System.out.println("TEN integers:");
                break;
            case HUNDRED:
                System.out.println("HUNDRED integers:");
                break;
            case THOUSAND:
                System.out.println("THOUSAND integers:");
                break;
        }
        printStringOfIntegers(sortedInts);
        printTable(tenInts_measurements);
        printTable(hundredInts_measurements);
        printTable(thousandInts_measurements);
    }

    private static void printStringOfIntegers(int[] ints){
        String stringWithIntegers = "";
        for (int integer : ints) {
            stringWithIntegers += integer + ", ";
        }
        StringBuffer stringBuffer = new StringBuffer(stringWithIntegers);
        stringBuffer.deleteCharAt(stringWithIntegers.length() - 2);
        System.out.println(stringBuffer);
    }

    private static void printTable(Map<String, Map<String, Double>> measurements){
        DecimalFormat decimalFormat = new DecimalFormat("#.######");

        String lineseperator = "--------------|--------------|--------------|--------------|--------------|-";

        String swap_time = String.valueOf(decimalFormat.format(measurements.get("swap").get("time")));
        String swap_memory = String.valueOf(decimalFormat.format(measurements.get("swap").get("memory")));
        String swap_comparisons = String.valueOf(decimalFormat.format(measurements.get("swap").get("comparisons")));
        String swap_loops = String.valueOf(decimalFormat.format(measurements.get("swap").get("loops")));

        String insertion_time = String.valueOf(decimalFormat.format(measurements.get("insertion").get("time")));
        String insertion_memory = String.valueOf(decimalFormat.format(measurements.get("insertion").get("memory")));
        String insertion_comparisons = String.valueOf(decimalFormat.format(measurements.get("insertion").get("comparisons")));
        String insertion_loops = String.valueOf(decimalFormat.format(measurements.get("insertion").get("loops")));

        String merge_time = String.valueOf(decimalFormat.format(measurements.get("merge").get("time")));
        String merge_memory = String.valueOf(decimalFormat.format(measurements.get("merge").get("memory")));
        String merge_comparisons = String.valueOf(decimalFormat.format(measurements.get("merge").get("comparisons")));
        String merge_loops = String.valueOf(decimalFormat.format(measurements.get("merge").get("loops")));

        String bubble_time = String.valueOf(decimalFormat.format(measurements.get("bubble").get("time")));
        String bubble_memory = String.valueOf(decimalFormat.format(measurements.get("bubble").get("memory")));
        String bubble_comparisons = String.valueOf(decimalFormat.format(measurements.get("bubble").get("comparisons")));
        String bubble_loops = String.valueOf(decimalFormat.format(measurements.get("bubble").get("loops")));

        String quick_time = String.valueOf(decimalFormat.format(measurements.get("quick").get("time")));
        String quick_memory = String.valueOf(decimalFormat.format(measurements.get("quick").get("memory")));
        String quick_comparisons = String.valueOf(decimalFormat.format(measurements.get("quick").get("comparisons")));
        String quick_loops = String.valueOf(decimalFormat.format(measurements.get("quick").get("loops")));

        System.out.println(makeALineForTable("","Time(ms)", "Memory(byte)", "Comparisons", "loops"));
        System.out.println(lineseperator);
        System.out.println(makeALineForTable("SwapSort", swap_time, swap_memory, swap_comparisons, swap_loops));
        System.out.println(lineseperator);
        System.out.println(makeALineForTable("InsertionSort", insertion_time, insertion_memory, insertion_comparisons, insertion_loops));
        System.out.println(lineseperator);
        System.out.println(makeALineForTable("MergeSort", merge_time, merge_memory, merge_comparisons, merge_loops));
        System.out.println(lineseperator);
        System.out.println(makeALineForTable("BubbleSort", bubble_time, bubble_memory, bubble_comparisons, bubble_loops));
        System.out.println(lineseperator);
        System.out.println(makeALineForTable("QuickSort", quick_time, quick_memory, quick_comparisons, quick_loops));
        System.out.println("\n\n");

    }

    private static String makeALineForTable(String firstColumn, String secondColumn, String thirdColumn, String fourthColumn, String fifthColumn){
        String line = makeStringLengthFourteen(firstColumn) + "|";
        line += makeStringLengthFourteen(secondColumn) + "|";
        line += makeStringLengthFourteen(thirdColumn) + "|";
        line += makeStringLengthFourteen(fourthColumn) + "|";
        line += makeStringLengthFourteen(fifthColumn) + "|";

        return line;
    }

    private static String makeStringLengthFourteen(String s){
        if (s == null){
            s = "";
        }
        while (s.length() < 14){
            s = " " + s;
        }
        return s;
    }
}

