
public class ConvertHourFormat {

    public void convertFormat(String hour) {
        String[] parts = hour.split(" ");
        String[] hourParts = parts[0].split(":");
        int hourValue = Integer.parseInt(hourParts[0]);
        String ampm;
        if (parts.length == 2) {
            ampm = parts[1].toLowerCase();
            if (ampm.startsWith("a") && Integer.parseInt(hourParts[0]) == 12) {
                hourParts[0] = "00";
            } else if (ampm.startsWith("p") && Integer.parseInt(hourParts[0]) != 12) {
                hourParts[0] = String.valueOf((hourValue + 12));
            }
            System.out.println("Formatted hour: " + hourParts[0] + ":" + hourParts[1]);
        } else if (Integer.parseInt(hourParts[0]) < 24) {
            if (Integer.parseInt(hourParts[0]) >= 12) {
                ampm = "PM";
                hourParts[0] = String.format("%02d", (hourValue - 12));
                if (hourValue - 12 == 0) {
                    hourParts[0] = "12";
                }
            } else {
                ampm = "AM";
                if (hourValue == 0) {
                    hourParts[0] = "12";
                }
            }
            System.out.println("Formatted hour: " + hourParts[0] + ":" + hourParts[1] + " " + ampm);
        }
    }
}
