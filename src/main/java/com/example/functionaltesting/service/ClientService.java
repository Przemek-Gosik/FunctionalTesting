package com.example.functionaltesting.service;

import com.example.functionaltesting.domain.Client;
import com.example.functionaltesting.domain.ClientContact;
import com.example.functionaltesting.domain.ClientDetails;
import com.example.functionaltesting.domain.ClientDetailsEntity;
import com.example.functionaltesting.repository.ClientDetailsRepository;
import com.example.functionaltesting.webclient.ClientContactsAPIClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientDetailsRepository
            clientDetailsRepository;
    private final ClientContactsAPIClient contactsAPIClient;
    public Client getClient(long clientId) {
        ClientDetailsEntity clientDetailsEntity =
                clientDetailsRepository.getReferenceById(clientId);
        ClientDetails clientDetails =
                ClientDetails.fromEntity(clientDetailsEntity);
        ClientContact clientContact =
                contactsAPIClient.getClientContact(clientId);
        return Client.of(clientDetails, clientContact);
    }

    public void saveClientDetails(long clientId,
                                  ClientDetails clientDetails) {
        ClientDetailsEntity clientDetailsEntity =
                clientDetails.toEntity(clientId);
        clientDetailsRepository.save(clientDetailsEntity);
    }

    public ClientDetails getClientDetails(long clientId) {
        ClientDetailsEntity clientDetailsEntity =
                clientDetailsRepository.getReferenceById(clientId);
        return ClientDetails.fromEntity(clientDetailsEntity);
    }


}
