
import java.time.Year;

public class DayThree {
    public String dayName(int number) {
        return switch (number) {
            case 1 -> "Senin";
            case 2 -> "Selasa";
            case 3 -> "Rabu";
            case 4 -> "Kamis";
            case 5 -> "Jumat";
            case 6 -> "Sabtu";
            case 7 -> "Minggu";
            default -> "Urutan Hari tidak ditemukan di planet bumi";
        };
    }

    public int DayNumber(String day) {
        return switch (day.toLowerCase()) {
            case "senin" -> 1;
            case "selasa" -> 2;
            case "rabu" -> 3;
            case "kamis" -> 4;
            case "jumat" -> 5;
            case "sabtu" -> 6;
            case "minggu" -> 7;
            default -> -1;
        };
    }

    public void twoDaysAroundNow(String day) {
        int dayNumber = DayNumber(day);
        if (dayNumber == -1)
            System.out.println("Hari yang anda masukkan salah!");
        else {
            String dMinusOne = dayNumber - 1 < 1 ? dayName(dayNumber + 7 - 1) : dayName(dayNumber-1);
            String dMinusTwo = dayNumber - 2 < 1 ? dayName(dayNumber + 7 - 2) : dayName(dayNumber-2);
            String dDay = dayName(dayNumber);
            String dPlusOne = dayNumber + 1 > 7 ? dayName(dayNumber - 7 + 1) : dayName(dayNumber+1);
            String dPlusTwo = dayNumber + 2 > 7 ? dayName(dayNumber - 7 + 2) : dayName(dayNumber+2);
            System.out.println(
                "Kemarin lusa adalah hari\t" + dMinusTwo +
                "\nKemarin adalah hari\t\t" + dMinusOne +
                "\nHari ini adalah hari\t\t" + dDay +
                "\nBesok adalah hari\t\t" + dPlusOne +
                "\nBesok lusa adalah hari\t\t" + dPlusTwo
            );
        }
    }
    
    public void leapYear(int year) {
        System.out.println("Leap Years after " + year + " :");
        int i = year;
        for (; i < Year.now().getValue(); i++) {
            if (i % 4 != 0 || (i % 100 == 0 && i % 400 != 0)) continue;
            System.out.print(i + ", ");
        }
        System.out.print(i + ".");
    }

    public void oddEvenAddition(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println((i*2-1) + " + " + (i*2) + " = " + (i*4-1));
        }
    }
}
