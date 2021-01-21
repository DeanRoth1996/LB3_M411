public class SwapSorter {

    public void sort(int[] sortMe) {

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

    /* Testmain
    public static void main(String[] args) {

        int[] a = {3, 7, 45, 1, 33, 5, 2, 9};
        System.out.print("unsorted: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();
        new SwapSorter().sort(a);
        System.out.print("sorted: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }*/
}