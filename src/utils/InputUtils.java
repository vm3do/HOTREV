package utils;

import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public static String readEmail(String message) {
        while (true) {
            String email = readString(message);
            String error = Validation.validateEmail(email);
            if (error == null) {
                return email;
            }
            System.out.println("❌ " + error + " Please try again.");
        }
    }

    public static String readPassword(String message) {
        while (true) {
            String password = readString(message);
            String error = Validation.validatePassword(password);
            if (error == null) {
                return password;
            }
            System.out.println("❌ " + error + " Please try again.");
        }
    }

    public static String readFullName(String message) {
        while (true) {
            String fullName = readString(message);
            String error = Validation.validateFullName(fullName);
            if (error == null) {
                return fullName;
            }
            System.out.println("❌ " + error + " Please try again.");
        }
    }

    public static String readHotelName(String message) {
        while (true) {
            String name = readString(message);
            String error = Validation.validateHotelName(name);
            if (error == null) {
                return name;
            }
            System.out.println("❌ " + error + " Please try again.");
        }
    }


    public static String readAddress(String message) {
        while (true) {
            String address = readString(message);
            String error = Validation.validateAddress(address);
            if (error == null) {
                return address;
            }
            System.out.println("❌ " + error + " Please try again.");
        }
    }


    public static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }
    }


    public static int readRoomCount(String message) {
        while (true) {
            int rooms = readInt(message);
            String error = Validation.validateRoomCount(rooms);
            if (error == null) {
                return rooms;
            }
            System.out.println("❌ " + error + " Please try again.");
        }
    }

    public static int readNights(String message) {
        while (true) {
            int nights = readInt(message);
            String error = Validation.validateNights(nights);
            if (error == null) {
                return nights;
            }
            System.out.println("❌ " + error + " Please try again.");
        }
    }

    public static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }
    }

    public static double readRating(String message) {
        while (true) {
            double rating = readDouble(message);
            String error = Validation.validateRating(rating);
            if (error == null) {
                return rating;
            }
            System.out.println("❌ " + error + " Please try again.");
        }
    }

    public static boolean readYesNo(String message) {
        while (true) {
            String input = readString(message + " (y/n): ").toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            }
            System.out.println("❌ Please enter 'y' for yes or 'n' for no.");
        }
    }
}
