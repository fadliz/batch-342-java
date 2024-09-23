import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scn = new Scanner(System.in)) {
            DayFive training = new DayFive();
            
            System.out.print("Input Number : ");
            int number = Integer.parseInt(scn.nextLine());
            // training.patternedAsteriskOne(number);
            training.reversedCountMatrix(number);
            System.out.println();
            // training.patternedAsteriskTwo(number);
            training.oddEvenCountMatrix(number);
            
            scn.close();
        }
    }

}