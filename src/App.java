import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scn = new Scanner(System.in)) {
            DaySix training = new DaySix();

            // System.out.print("Input Number of bottle : ");
            // int number = Integer.parseInt(scn.nextLine());
            // System.out.print("Input target conversion : ");
            // String words = scn.nextLine();
            // // training.betterSortWords(words);

            // System.out.println(number+" botol = "
            // +training.convertVolumes(number, words)
            // +" "+words);

            training.FoodPortion();
            scn.close();
        }
    }

}