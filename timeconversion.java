import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class timeconversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input for local time zone
        System.out.print("Enter your local time zone : ");
        String localZoneIdStr = sc.nextLine();
        ZoneId localZoneId = ZoneId.of(localZoneIdStr);

        // Taking user input for country time zone
        System.out.print("Enter the country time zone: ");
        String countryZoneIdStr = sc.nextLine();
        ZoneId countryZoneId = ZoneId.of(countryZoneIdStr);

        // Convert local time to country time
        LocalDateTime localDateTime = LocalDateTime.now(localZoneId);
        LocalDateTime countryDateTime = localDateTime.atZone(localZoneId).withZoneSameInstant(countryZoneId).toLocalDateTime();

        // Formating Date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = formatter.format(localDateTime);
        String countryTime = formatter.format(countryDateTime);

        // Showing output
        System.out.println("Local time (" + localZoneId + "): " + localTime);
        System.out.println("Country time (" + countryZoneId + "): " + countryTime);
        sc.close();;
    }
}