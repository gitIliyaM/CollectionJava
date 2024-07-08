package ComparableComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Dodelat {
    public class MainComparableComparator {
        static int numberFromScanner;

        public static void main(String[] args) {
            ArrayList<Integer> arrayList = getRandomNumbers();
            System.out.println(arrayList);
        }

        static ArrayList<Integer> getRandomNumbers() {
            numberFromScanner = scanner();
            int i = numberFromScanner;
            Random random = new Random();
            ArrayList<Integer> arrayList = new ArrayList<>();

            while (i > 0) {
                int intRandom = random.nextInt(numberFromScanner);
                arrayList.add(intRandom);

                //if(i == 0){

                //}
                i--;
            }
            arrayList = getNumbers(arrayList);
            return arrayList;
        }

        static int scanner() {
            System.out.println("введите любое целое число");
            Scanner scanner = new Scanner(System.in);
            int i;
            return i = scanner.nextInt();
        }

        static ArrayList<Integer> getNumbers(ArrayList arrayList) {
            Collections.sort(arrayList);//getRandomNewNumber(numberFromScanner);
            return arrayList;
        }

        static int getRandomNewNumber(int numberFromScanner) {
            Random random = new Random();
            int intRandom = random.nextInt(numberFromScanner);
            return intRandom;
        }
    }
}
