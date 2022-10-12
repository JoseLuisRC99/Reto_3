package com.example.reto_c3.Service;


import com.example.reto_c3.Model.Client;
import com.example.reto_c3.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if (client.getIdClient()== null){
            return clientRepository.save(client);
        }else{
            Optional<Client> clientEncontrado = getClient(client.getIdClient());
            if (clientEncontrado.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }

    public Client update(Client client){
        if (client.getIdClient() != null){
            Optional<Client> clientEncontrado = getClient(client.getIdClient());
            if (!clientEncontrado.isEmpty()){
                if (client.getName() != null){
                    clientEncontrado.get().setName(client.getName());
                }
                if (client.getAge() != null){
                    clientEncontrado.get().setAge(client.getAge());
                }
                if (client.getPassword() != null){
                    clientEncontrado.get().setPassword(client.getPassword());
                }
                return clientRepository.save(clientEncontrado.get());
            }
        }
        return client;
    }

    public boolean delete(int id){
        Boolean respuesta = getClient(id).map(elemento ->{
            clientRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }
}

