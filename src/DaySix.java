
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// import java.util.HashMap;

public class DaySix {
    public void sortWords(String str) {
        String lowerStr = str.toLowerCase().trim(); //FIXME:either add .replaceAll(" ","")
        String vokal = ""; // Kata ChatGPT improve pake string builder
        String konsonan = ""; // Kata ChatGPT improve pake string builder
        char[] chrs = lowerStr.toCharArray();
        Arrays.sort(chrs);
        for (Character chr : chrs) { //FIXME: or check if isLetter here
            if ("aiueo".contains(chr.toString())) { // Kata ChatGPT improve pake HashSet
                vokal += chr.toString(); // Kata ChatGPT improve pake string builder append
            } else {
                konsonan += chr.toString(); // Kata ChatGPT improve pake string builder append
            }
        }
        System.out.println(
                "Huruf Vokal : " + vokal +
                        "\nHuruf Konsonan : " + konsonan);

    }

    public void betterSortWords(String str) { // IMPROVED BY CHATGPT
        Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'i', 'u', 'e', 'o'));
        if (str == null || str.trim().isEmpty()) {
            System.out.println("Input is empty or null");
            return;
        }

        String lowerStr = str.toLowerCase().trim();
        StringBuilder vowels = new StringBuilder();
        StringBuilder consonants = new StringBuilder();

        char[] chrs = lowerStr.toCharArray();
        Arrays.sort(chrs); // Sorting the characters

        for (char chr : chrs) {
            if (Character.isLetter(chr)) { // Only process alphabetic characters
                if (VOWELS.contains(chr)) {
                    vowels.append(chr);
                } else {
                    consonants.append(chr);
                }
            }
        }

        System.out.println("Huruf Vokal : " + vowels);
        System.out.println("Huruf Konsonan : " + consonants);
    }

    // no.6
    public void menu() {
        System.out.println();
        System.out.println("==========================================");
        System.out.println("||\t\t  M E N U\t\t||");
        System.out.println("=====================|====================");
        System.out.println("|| 1. Input Number of Adult Male\t||");
        System.out.println("|| 2. Input Number of Adult Female\t||");
        System.out.println("|| 3. Input Number of Teenager\t\t||"); // remaja anak2 balita
        System.out.println("|| 4. Input Number of Kids\t\t||");
        System.out.println("|| 5. Input Number of Toddlers\t\t||");
        System.out.println("|| 0. Quit and Calculate\t\t||");
        System.out.println("==========================================");
    }

    public void FoodPortion() {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputMenu, adultMale = 0, adultFemale = 0, teenager = 0, kids = 0, toddlers = 0;
            do {
                menu();
                System.out.print("Input menu number: ");
                inputMenu = Integer.parseInt(scanner.nextLine());
                switch (inputMenu) {
                    case 1 -> {
                        System.out.print("Input number of Adult Male to be added: ");
                        adultMale += Integer.parseInt(scanner.nextLine());
                        System.out.println("Current number of Adult Male -> " + adultMale);
                    }
                    case 2 -> {
                        System.out.print("Input number of Adult Female to be added: ");
                        adultFemale += Integer.parseInt(scanner.nextLine());
                        System.out.println("Current number of Adult Female -> " + adultFemale);
                    }
                    case 3 -> {
                        System.out.print("Input number of Teenager to be added: ");
                        teenager += Integer.parseInt(scanner.nextLine());
                        System.out.println("Current number of Teenager -> " + teenager);
                    }
                    case 4 -> {
                        System.out.print("Input number of Kids to be added: ");
                        kids += Integer.parseInt(scanner.nextLine());
                        System.out.println("Current number of Kids -> " + kids);
                    }
                    case 5 -> {
                        System.out.print("Input number of Toddlers to be added: ");
                        toddlers += Integer.parseInt(scanner.nextLine());
                        System.out.println("Current number of Toddlers -> " + toddlers);
                    }
                    case 0 -> {
                        System.out.print("");
                    }
                    default -> {
                        System.out.println("Invalid menu number. Please try again.");
                    }
                }
                if (inputMenu != 0) {
                    System.out.print("Continue ? (Y/N) : ");
                    String continueInput = scanner.nextLine().toLowerCase();
                    inputMenu = continueInput.equals("n") ? 0 : -1;
                }
            } while (inputMenu != 0);
            System.out.println();
            System.out.println("Calculating . . .");
            int peopleCount = adultMale + adultFemale + teenager + kids + toddlers;
            if (peopleCount % 2 != 0 && peopleCount > 5)
                adultFemale *= 2;
            double portionCount = adultMale * 2 + adultFemale + teenager + (kids / 2) + toddlers;
            System.out.println("Portion of foods eaten -> " + portionCount);
            System.out.println();
            System.out.println("Quitting . . .");
        }
    }

    // alt no.6 using 1 string input
    public void foodPortion(String input) {
        String[] words = input.trim().replaceAll(",", "").split("orang");
        HashMap<String, Double> portions = new HashMap<>();
        for (String string : words) {
            String[] parts = string.toLowerCase().trim().split(" = ");
            String key = parts[0].trim().replace(" dewasa", "");
            System.out.println(key);
            String val = parts[1].trim();
            if (portions.containsKey(key)) portions.put(key, portions.get(key)+Double.valueOf(val));
            portions.putIfAbsent(key, Double.valueOf(val));
        }
        final int[] peopleCount = {0};
        portions.forEach((key,value) -> {peopleCount[0] += value;});
        portions.forEach((key, value) -> {
            switch (key) {
                case "laki-laki" -> {
                    portions.put(key,value * 2);
                }
                case "perempuan" -> {
                    if (peopleCount[0] % 2 != 0 && peopleCount[0] > 5) portions.put(key,value * 2);
                }
                case "anak-anak" -> {
                    portions.put(key,value /2);
                }
                default -> {
                }
            };
        });
        double portionCount = 0;
        for (Double count : portions.values()) {
            System.out.println(count);
            portionCount += count;
        }
        System.out.println(portionCount + " porsi");
    }

    // no.7
    // A botol B Gelas C Cangkir D teko
    public double convertVolumes(double num, String to) { // TODO: implement dynamic conversion from any start
        num = num * 2;
        if (to.equalsIgnoreCase("gelas"))
            return num;
        num = num * 5 / 2;
        if (to.equalsIgnoreCase("cangkir"))
            return num;
        num = num / 25;
        if (to.equalsIgnoreCase("teko"))
            return num;
        return -1;
    }
}
