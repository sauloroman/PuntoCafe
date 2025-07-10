package utils.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Formatter {
 
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    
    public static String formatDate( Date date ) {
        if ( date == null ) return "";
        return sdf.format(date);
    }
    
    public static String formatNumber(String phone) {
        return "";
    }
    
    public static String extractName(String input) {
        if (input == null || !input.contains("-")) return input;
        return input.split("-")[0].trim();
    }
    
}
