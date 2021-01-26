import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] tenInts = readFile("./ressources/10Digits.txt", new int[10]);
        int[] hundredInts = readFile("./ressources/100Digits.txt", new int[100]);
        int[] thousandInts = readFile("./ressources/1000Digits.txt", new int[100]);


    }

    private static int[] readFile(String path, int[] array){
        int index = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\\s+","");      //removes all whitespaces from String
                array[index] = Integer.parseInt(line);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }
}

