
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ShipmentDate {

    private Integer dateShipped;
    private String dayShipped;
    private final Map<String, Integer> daysMap = Map.of(
            "senin", 1,
            "selasa", 2,
            "rabu", 3,
            "kamis", 4,
            "jumat", 5,
            "sabtu", 6,
            "minggu", 7
    );

    public int getDaysNumber(String day) {
        return daysMap.getOrDefault(day, 0);
    }

    public ArrayList<Integer> getHolidayDate(String dates) {
        ArrayList<Integer> dateList = new ArrayList<>();
        String[] dateArr = dates.replaceAll("[^,0-9]", "").split(",");
        for (String string : dateArr) {
            dateList.add(Integer.valueOf(string));
        }
        return dateList;
    }

    public HashMap<Integer, String> getDayOfHoliday(ArrayList<Integer> dateList) {
        HashMap<Integer, String> dayOfHoliday = new HashMap<>();
        for (Integer date : dateList) {
            Integer dateDiff = getDaysNumber(this.dayShipped) + ((date - dateShipped) % 7);
            dateDiff = dateDiff > 7 ? dateDiff - 7 : dateDiff;
            String dateDiffStr = null;
            for (Map.Entry<String, Integer> entry : daysMap.entrySet()) {
                if (Objects.equals(entry.getValue(), dateDiff)) {
                    dateDiffStr = entry.getKey();
                    break; // Stop once the day is found
                }
            }
            dayOfHoliday.put(date, dateDiffStr);
        }
        return dayOfHoliday;
    }

    public void calculateEstimatedDateReceived() {
        Integer estimatedTimeTaken = 7;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Tanggal dan Hari pemesanan: ");
            String dates = scanner.nextLine();
            String[] parts = dates.split(" ");
            this.dateShipped = Integer.valueOf(parts[0]);
            this.dayShipped = parts[1].toLowerCase();

            System.out.print("Hari libur nasional: ");
            String holidays = scanner.nextLine();
            HashMap<Integer, String> dayOfHolidays = getDayOfHoliday(getHolidayDate(holidays));

            int dayOfWeek = getDaysNumber(this.dayShipped);
            for (int i = 1; i <= estimatedTimeTaken; i++) {
                dayOfWeek++;
                if (dayOfWeek>7) {
                    dayOfWeek = 1;
                }
                int countDate = this.dateShipped + i;
                countDate = countDate > 31 ? countDate - 31 : countDate;
                if (daysMap.get("sabtu") == dayOfWeek || daysMap.get("minggu") == dayOfWeek) {
                    estimatedTimeTaken++;
                } else if (dayOfHolidays.containsKey(countDate)) {
                    if (daysMap.get(dayOfHolidays.get(countDate)) < 6) {
                        estimatedTimeTaken++;
                    }
                } 
            }
            Integer dateReceived = (this.dateShipped + estimatedTimeTaken);
            if (dateReceived > 31) {
                dateReceived -= 31;
                System.out.println("Tanggal " + dateReceived + " di bulan berikutnya");
            } else {
                System.out.println("Tanggal " + dateReceived + " di bulan yang sama");

            }
        } catch (Exception e) {
            System.out.print("\nAda yang error di ");
            System.out.println(e.getMessage());
            System.out.print("jir . . dahlah . .");
        }
    }
}
