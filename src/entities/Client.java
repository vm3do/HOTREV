package entities;

import java.util.UUID;

public class Client {
    private UUID id;
    private String fullName;
    private String email;
    private String password;
    private boolean isAdmin;

    public Client(String email, String fullName, String password, boolean isAdmin) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
