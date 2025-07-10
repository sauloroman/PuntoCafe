package utils.validators;

public final class SupplierValidator {
    
    public static boolean isValidName(String name) {
        if ( name == null ) return false;
        name = name.trim();
        return !name.isEmpty() && name.length() <= 100;
    }
    
    public static boolean isValidLastName(String lastname) {
        if ( lastname == null ) return false;
        lastname = lastname.trim();
        return !lastname.isEmpty() && lastname.length() <= 100;
    }
    
    public static boolean isValidCompany(String company) {
        if ( company == null ) return false;
        company = company.trim();
        return !company.isEmpty() && company.length() <= 100;
    }
    
    public static boolean isValidPhone(String phone) {
        if (phone == null) return false;
        phone = phone.trim();
        if (phone.isEmpty() || phone.length() > 15) return false;
 
        if (!phone.matches("[0-9\\-]+")) return false;

        if (!Character.isDigit(phone.charAt(0)) || !Character.isDigit(phone.charAt(phone.length() - 1))) {
            return false;
        }
        
        if (phone.contains("--")) return false;

        String digitsOnly = phone.replaceAll("-", "");
        return digitsOnly.length() == 10;
    }
    
    public static boolean isValidEmail(String email) {
        if ( email == null ) return false;
        email = email.trim();
        return EmailValidator.isValidEmail(email) && email.length() <= 100;
    }
    
     public static boolean isValidAddress(String address) {
        if ( address == null ) return false;
        address = address.trim();
        return address.length() <= 200;
    }
    
}
