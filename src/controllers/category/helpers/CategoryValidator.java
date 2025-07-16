package controllers.category.helpers;

public class CategoryValidator {
    
    public static boolean isValidName(String name) {
        if ( name == null ) return false;
        name = name.trim();
        return !name.isEmpty() && name.length() < 100;
    }
    
    public static boolean isValidDescription(String description) {
        if ( description == null ) return false;
        description = description.trim();
        return description.length() < 220;
    }
    
}
