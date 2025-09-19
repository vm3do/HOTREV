package repositories;

import entities.Client;

import java.util.HashMap;

public interface ClientRepository {

    public void saveClient(Client client);
    public Client findByEmail(String email);
}
