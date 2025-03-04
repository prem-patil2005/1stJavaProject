
package Validation;


public class ValidationUtil {
    
    public static boolean isValidName(String name) {
        String invalidChars = "0123456789!@#$%^&*()_+=<>?/\\";
        for (int i = 0; i < name.length(); i++) {
            if (invalidChars.contains(String.valueOf(name.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidAddress(String address) {
        String invalidChars = "!@#$%^&*()_+=<>?/\\";
        for (int i = 0; i < address.length(); i++) {
            if (invalidChars.contains(String.valueOf(address.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidMobileNumber(int mobile) {
        String mobStr = String.valueOf(mobile);
        return mobStr.matches("[0-9]{10}");
    }

    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public static boolean isValidRollNumber(int roll) {
        return String.valueOf(roll).matches("[0-9]+");
    }
}
