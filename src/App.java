import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scn = new Scanner(System.in)) {
            DailyTraining  training = new DailyTraining();
            // WarmupOne fungsi = new WarmupOne();

            System.out.println("");
            // System.out.println(fungsi.startHi("cat"));
            // System.out.println(training.factorial());
            // training.matrixPrint();
            
            System.out.print("Masukkan angka: ");
            int dayNum = Integer.parseInt(scn.nextLine());
            System.out.println(training.dayName(dayNum));

            System.out.print("Masukkan Hari: ");
            String dayName = scn.nextLine();
            System.out.println(training.DayNumber(dayName));
            
            scn.close();
        }
    }

}