package com.example.functionaltesting.webclient;

import com.example.functionaltesting.domain.ClientContact;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class ClientContactsAPIClient {

    private final RestTemplate restTemplate;
    private final String contactsServiceUrl;

    public ClientContactsAPIClient(final RestTemplateBuilder
                                           restTemplateBuilder,
                                   @Value("${contacts.service.url}") final String
                                           contactsServiceUrl) {
        this.restTemplate = restTemplateBuilder.build();
        this.contactsServiceUrl = contactsServiceUrl;
    }

    public ClientContact getClientContact(long clientId) {
        URI uri =
                UriComponentsBuilder.fromHttpUrl(
                                contactsServiceUrl + "/contact")
                        .queryParam("clientId",clientId)
                        .build().toUri();
        return restTemplate.getForObject(uri,
                ClientContact.class);
    }
}
