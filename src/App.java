import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scn = new Scanner(System.in)) {
            DayFive training = new DayFive();
            
            System.out.print("Input Number : ");
            int numberTwo = Integer.parseInt(scn.nextLine());
            training.patternedAsteriskOne(numberTwo);
            System.out.println();
            training.patternedAsteriskTwo(numberTwo);

            scn.close();
        }
    }

}