package com.example.CSVfileImporterandValidator.validator;

public class UserValidator {
    public static boolean isValid(String name, String email, String ageStr) {
        if (name == null || name.isBlank()) return false;
        if (email == null || !email.contains("@")) return false;
        try {
            Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

