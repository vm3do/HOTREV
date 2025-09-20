package utils;

public class Validation {
    
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    
    public static String validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return "Email is required";
        }
        if (!email.trim().matches(EMAIL_REGEX)) {
            return "Invalid email format (example: user@domain.com)";
        }
        return null;
    }
    
    public static String validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return "Password is required";
        }
        if (password.length() < 6) {
            return "Password must be at least 6 characters long";
        }
        return null;
    }
    
    public static String validateFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return "Full name is required";
        }
        if (fullName.trim().length() < 2) {
            return "Full name must be at least 2 characters long";
        }
        if (fullName.trim().length() > 50) {
            return "Full name cannot exceed 50 characters";
        }
        return null;
    }
    
    public static String validateHotelName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hotel name is required";
        }
        if (name.trim().length() < 2) {
            return "Hotel name must be at least 2 characters long";
        }
        if (name.trim().length() > 100) {
            return "Hotel name cannot exceed 100 characters";
        }
        return null;
    }
    
    public static String validateAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            return "Address is required";
        }
        if (address.trim().length() < 5) {
            return "Address must be at least 5 characters long";
        }
        if (address.trim().length() > 200) {
            return "Address cannot exceed 200 characters";
        }
        return null;
    }
    

    public static String validateRoomCount(int rooms) {
        if (rooms <= 0) {
            return "Number of rooms must be greater than 0";
        }
        if (rooms > 1000) {
            return "Number of rooms cannot exceed 1000";
        }
        return null;
    }
    
    public static String validateNights(int nights) {
        if (nights <= 0) {
            return "Number of nights must be greater than 0";
        }
        if (nights > 365) {
            return "Number of nights cannot exceed 365";
        }
        return null;
    }
    
    public static String validateRating(double rating) {
        if (rating < 0.0) {
            return "Rating cannot be negative";
        }
        if (rating > 5.0) {
            return "Rating cannot exceed 5.0";
        }
        return null;
    }
}