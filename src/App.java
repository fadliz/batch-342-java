import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scn = new Scanner(System.in)) {
            DayFour training = new DayFour();
            
            // System.out.print("Input year : ");
            // int year = Integer.parseInt(scn.nextLine());
            // training.leapYear(year);

            // System.out.print("Input Row : ");
            // int number = Integer.parseInt(scn.nextLine());
            System.out.print("Input Number : ");
            int numberTwo = Integer.parseInt(scn.nextLine());
            // training.matrixStarPrint(numberTwo);
            System.out.print("Is the triangle reversed (true/false)? ");
            boolean reverse = Boolean.parseBoolean(scn.nextLine());
            training.triangleNumPrint(numberTwo, reverse);
            System.out.println();
            training.triangleNumPrintAsterisk(numberTwo, reverse);

            scn.close();
        }
    }

}