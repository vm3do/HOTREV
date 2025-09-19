package repositories.imp;

import entities.Client;
import repositories.ClientRepository;
import repositories.ReservationRepository;

import java.util.HashMap;

public class ClientRepositoryImp implements ClientRepository {
    private HashMap<String, Client> clients = new HashMap<>();

    @Override
    public Client findByEmail(String email) {
        return clients.get(email);
    }

    @Override
    public void saveClient(Client client) {
        clients.put(client.getEmail(), client);
    }
}
