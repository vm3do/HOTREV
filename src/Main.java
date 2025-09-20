import entities.Client;
import repositories.ClientRepository;
import repositories.imp.ClientRepositoryImp;
import services.AuthService;
import utils.InputUtils;

public class Main {
    private static AuthService authService;
    private static boolean running = true;

    public static void main(String[] args) {
        System.out.println("🏨 Welcome to HOTREV - Hotel Reservation System");
        System.out.println("================================================");
        
        initializeSystem();
        
        while (running) {
            showMainMenu();
        }
        
        System.out.println("👋 Thank you for using HOTREV!");
    }

    private static void initializeSystem() {
        ClientRepository clientRepository = new ClientRepositoryImp();
        authService = new AuthService(clientRepository);
        System.out.println("✅ System initialized successfully!");
    }

    private static void showMainMenu() {
        System.out.println("\n📋 MAIN MENU");
        System.out.println("=============");
        
        if (authService.isLoggedIn()) {
            Client currentUser = authService.getCurrentUser();
            System.out.println(" Logged in as: " + currentUser.getFullName());
            if (currentUser.isAdmin()) {
                System.out.println("🔑 Admin privileges");
            }
            showLoggedInMenu();
        } else {
            showNotLoggedInMenu();
        }
    }

    private static void showNotLoggedInMenu() {
        System.out.println("1. 📝 Register");
        System.out.println("2. 🔐 Login");
        System.out.println("3. ❌ Exit");
        
        int choice = InputUtils.readInt("Choose an option (1-3): ");
        
        switch (choice) {
            case 1:
                handleRegistration();
                break;
            case 2:
                handleLogin();
                break;
            case 3:
                running = false;
                break;
            default:
                System.out.println("❌ Invalid option. Please choose 1, 2, or 3.");
        }
    }

    private static void showLoggedInMenu() {
        System.out.println("1. 🏨 Create Hotel (Admin only)");
        System.out.println("2. 📋 List Hotels");
        System.out.println("3. 🛏️ Reserve Room");
        System.out.println("4. ❌ Cancel Reservation");
        System.out.println("5. 📊 Reservation History");
        System.out.println("6. 👤 Update Profile");
        System.out.println("7. 🔑 Change Password");
        System.out.println("8.  Logout");
        System.out.println("9. ❌ Exit");
        
        int choice = InputUtils.readInt("Choose an option (1-9): ");
        
        switch (choice) {
            case 1:
                handleCreateHotel();
                break;
            case 2:
                handleListHotels();
                break;
            case 3:
                handleReserveRoom();
                break;
            case 4:
                handleCancelReservation();
                break;
            case 5:
                handleReservationHistory();
                break;
            case 6:
                handleUpdateProfile();
                break;
            case 7:
                handleChangePassword();
                break;
            case 8:
                handleLogout();
                break;
            case 9:
                running = false;
                break;
            default:
                System.out.println("❌ Invalid option. Please choose 1-9.");
        }
    }

    private static void handleRegistration() {
        System.out.println("\n📝 REGISTRATION");
        System.out.println("================");
        
        String fullName = InputUtils.readFullName("Enter your full name: ");
        String email = InputUtils.readEmail("Enter your email: ");
        String password = InputUtils.readPassword("Enter your password (min 6 characters): ");
        boolean isAdmin = InputUtils.readYesNo("Are you an administrator?");
        
        String result = authService.register(fullName, email, password, isAdmin);
        
        if (result == null) {
            System.out.println("✅ Registration successful! You can now login.");
        } else {
            System.out.println("❌ Registration failed: " + result);
        }
    }

    private static void handleLogin() {
        System.out.println("\n🔐 LOGIN");
        System.out.println("=========");
        
        String email = InputUtils.readEmail("Enter your email: ");
        String password = InputUtils.readPassword("Enter your password: ");
        
        String result = authService.login(email, password);
        
        if (result == null) {
            Client user = authService.getCurrentUser();
            System.out.println("✅ Login successful! Welcome, " + user.getFullName() + "!");
        } else {
            System.out.println("❌ Login failed: " + result);
        }
    }

    private static void handleLogout() {
        authService.logout();
        System.out.println("✅ You have been logged out successfully.");
    }

    private static void handleUpdateProfile() {
        System.out.println("\n👤 UPDATE PROFILE");
        System.out.println("==================");
        
        Client currentUser = authService.getCurrentUser();
        System.out.println("Current profile:");
        System.out.println("Name: " + currentUser.getFullName());
        System.out.println("Email: " + currentUser.getEmail());
        
        String newFullName = InputUtils.readFullName("Enter new full name: ");
        String newEmail = InputUtils.readEmail("Enter new email: ");
        
        String result = authService.updateProfile(newFullName, newEmail);
        
        if (result == null) {
            System.out.println("✅ Profile updated successfully!");
        } else {
            System.out.println("❌ Update failed: " + result);
        }
    }

    private static void handleChangePassword() {
        System.out.println("\n🔑 CHANGE PASSWORD");
        System.out.println("==================");
        
        String currentPassword = InputUtils.readString("Enter your current password: ");
        String newPassword = InputUtils.readPassword("Enter new password (min 6 characters): ");
        String confirmPassword = InputUtils.readString("Confirm new password: ");
        
        if (!newPassword.equals(confirmPassword)) {
            System.out.println("❌ Passwords do not match.");
            return;
        }
        
        String result = authService.changePassword(currentPassword, newPassword);
        
        if (result == null) {
            System.out.println("✅ Password changed successfully!");
        } else {
            System.out.println("❌ Password change failed: " + result);
        }
    }

    private static void handleCreateHotel() {
        if (!authService.isCurrentUserAdmin()) {
            System.out.println("❌ Only administrators can create hotels.");
            return;
        }
        
        System.out.println("\n CREATE HOTEL");
        System.out.println("===============");
        
        String name = InputUtils.readHotelName("Enter hotel name: ");
        String address = InputUtils.readAddress("Enter hotel address: ");
        int rooms = InputUtils.readRoomCount("Enter number of rooms: ");
        double rating = InputUtils.readRating("Enter hotel rating (0.0 - 5.0): ");
        
        System.out.println("✅ Hotel created successfully!");
        System.out.println("Hotel: " + name + " at " + address + " with " + rooms + " rooms (Rating: " + rating + ")");
    }
}