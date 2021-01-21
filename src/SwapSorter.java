public class SwapSorter {

    public int[] sort(int[] sortMe) {

        int zahlenArray[] = sortMe;
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
        }
        return zahlenArray;
    }

    private int countSmallerOnes(final int[] countHere, final int index) {
        int counter = 0;
        for (int i = index + 1; i < countHere.length; i++) {
            if (countHere[index] > countHere[i]) {
                counter++;
            }
        }
        return counter;
    }
}