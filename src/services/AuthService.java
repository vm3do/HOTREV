package services;

import entities.Client;
import repositories.ClientRepository;

public class AuthService {
    private ClientRepository clientRepository;
    private Client currentUser;

    public AuthService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        this.currentUser = null;
    }

    public String register(String fullName, String email, String password, boolean isAdmin) {

        if (clientRepository.findByEmail(email) != null) {
            return "Email already exists. Please use a different email.";
        }

        Client newClient = new Client(email, fullName, password, isAdmin);
        
        clientRepository.saveClient(newClient);
        
        return null;
    }

    public String login(String email, String password) {
        
        Client client = clientRepository.findByEmail(email);
        if (client == null) {
            return "Invalid email or password.";
        }

        if (!client.getPassword().equals(password)) {
            return "Invalid email or password.";
        }

        this.currentUser = client;
        
        return null;
    }


    public void logout() {
        this.currentUser = null;
    }


    public Client getCurrentUser() {
        return currentUser;
    }


    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public boolean isCurrentUserAdmin() {
        return currentUser != null && currentUser.isAdmin();
    }

    public String updateProfile(String newFullName, String newEmail) {
        if (currentUser == null) {
            return "You must be logged in to update your profile.";
        }

        if (!newEmail.equals(currentUser.getEmail())) {
            if (clientRepository.findByEmail(newEmail) != null) {
                return "Email already exists. Please use a different email.";
            }
        }

        currentUser.setFullName(newFullName);
        currentUser.setEmail(newEmail);

        clientRepository.saveClient(currentUser);
        
        return null;
    }


    public String changePassword(String currentPassword, String newPassword) {
        if (currentUser == null) {
            return "You must be logged in to change your password.";
        }

        if (!currentUser.getPassword().equals(currentPassword)) {
            return "Current password is incorrect.";
        }

        currentUser.setPassword(newPassword);

        clientRepository.saveClient(currentUser);
        
        return null;
    }
}
