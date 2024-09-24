
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


// import java.util.HashMap;

public class DaySix {
    public void sortWords(String str) {
        String lowerStr = str.toLowerCase().trim();
        String vokal = ""; // Kata ChatGPT improve pake string builder
        String konsonan = ""; // Kata ChatGPT improve pake string builder
        char[] chrs = lowerStr.toCharArray();
        Arrays.sort(chrs);
        for (Character chr : chrs) {
            if ("aiueo".contains(chr.toString())) { // Kata ChatGPT improve pake HashSet
                vokal += chr.toString();  // Kata ChatGPT improve pake string builder append
            } else {
                konsonan += chr.toString(); // Kata ChatGPT improve pake string builder append
            }
        }

        System.out.println(
            "Huruf Vokal : " + vokal +
            "\nHuruf Konsonan : " + konsonan
        );

    }

    public void betterSortWords(String str) { //IMPROVED BY CHATGPT
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
}
