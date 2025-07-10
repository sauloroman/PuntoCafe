package utils.validators;

public class ProductValidator {
    
    public static boolean isValidName(String name) {
        if ( name == null ) return false;
        name = name.trim();
        return !name.isEmpty() && name.length() <= 100;
    }
    
    public static boolean isValidDescription(String description) {
        if ( description == null ) return false;
        description = description.trim();
        return description.length() <= 220;
    }
    
    public static boolean isValidImage(String image) {
        if ( image == null ) return false;
        image = image.trim();
        return image.length() <= 200;
    }
    
    public static boolean isValidSellingPrice( double price ) {
        return price > 0 && price < 1e9;
    }
    
    public static boolean isValidStock( int stock ) {
        return stock > 0; 
    }
    
    public static boolean isValidStockMinimum( int stock, int stockMin ) {
        return stockMin > 0 && stock > stockMin; 
    }
    
    public static boolean isValidCategoryId( int categoryId ) {
        return categoryId > 0;
    }
    
    public static boolean isValidSupplierId( int supplierId ) {
        return supplierId > 0;
    }
    
}
