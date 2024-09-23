import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scn = new Scanner(System.in)) {
            DayFive training = new DayFive();

            System.out.print("Input Number : ");
            int number = Integer.parseInt(scn.nextLine());
            int[] arr = new int[number];
            Arrays.setAll(arr, i -> (new Random()).nextInt(50));
            System.out.println(training.calculateMax(arr) + " " +
                    training.calculateMin(arr) + " " +
                    training.calculateMean(arr) + " " +
                    training.calculateMedian(arr) + " " +
                    training.calculateMode(arr));

            System.out.println();
            for (int i : arr) {
                System.out.print(i + " ");
            }

            scn.close();
        }
    }

}