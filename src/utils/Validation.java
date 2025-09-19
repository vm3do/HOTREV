package utils;

public class Validation {

    public boolean validEmail(String email){
        if(email.isEmpty() || email == null){
            return false;
        }

        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public boolean validPassword(String password){
        return !password.isEmpty() && password != null && password.length() >= 6;
    }
}