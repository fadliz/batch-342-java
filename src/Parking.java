
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Parking {

    public Long calculateTimePassed(LocalDateTime start, LocalDateTime end) {
        Long timePassed = ChronoUnit.SECONDS.between(start, end);
        return timePassed % 3600 == 0 ? timePassed / 3600 : (timePassed / 3600) + 1;
    }

    public LocalDateTime parseFromString(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy kk:mm:ss", new Locale("id", "ID"));
        return LocalDateTime.parse(date, dateTimeFormatter);
    }

    public Long calculateParkTariff(Long timePassed) {
        Long totalTariff = Long.valueOf(0);
        totalTariff += timePassed > 24 ? (15000 * (timePassed / 24)) : 0;
        timePassed = timePassed % 24;
        totalTariff += timePassed > 8 ? (8000) : (1000 * timePassed);
        return totalTariff;
    }

    public void printTariff() {
        System.out.println("Tarif Parkir");
        System.out.println("==============");
        System.out.println("Lebih dari 24 jam : 15000 per 24 jam");
        System.out.println("Lebih dari 8 jam : flat 8000");
        System.out.println("Lebih dari 1 jam : 1000 per jam");
        System.out.println("==============");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("- Masuk: ");
            LocalDateTime startDate = parseFromString(scanner.nextLine());
            System.out.print("- Keluar: ");
            LocalDateTime endDate = parseFromString(scanner.nextLine());
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("id","ID"));
            Long tariff = calculateParkTariff(calculateTimePassed(startDate, endDate));
            System.out.println("Besar tarif parkir : " + nf.format(tariff));
        } catch (DateTimeParseException e) {
            System.out.println("Format tanggal salah, silakan masukkan format \"hari bulan tahun jam:menit:detik\"");
            System.out.println("Contoh:(03 Februari 2020 07:30:34)");
        }
    }
}