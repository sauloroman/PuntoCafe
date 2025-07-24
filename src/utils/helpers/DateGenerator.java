package utils.helpers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateGenerator {

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public static String getCurrentDateTimeFormatted() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    public static String getCurrentDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return now.format(formatter);
    }

    public static String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    }

    public static String getPastDate(int daysAgo) {
        LocalDate date = LocalDate.now().minusDays(daysAgo);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
    
    public static String getCurrentDateEnd() {
        LocalDate date = LocalDate.now();
        return date + " 23:59:59";
    }
    
    public static String getCurrentDateStart(int daysAgo) {
        LocalDate date = LocalDate.now().minusDays(daysAgo);
        return date + " 00:00:00";
    }
}
