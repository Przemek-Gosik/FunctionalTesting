package com.example.functionaltesting.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class ClientDetails {
    String firstName;
    String lastName;

    public static ClientDetails
    fromEntity(ClientDetailsEntity entity) {
        return ClientDetails.of(entity.getFirstName(),
                entity.getLastName());
    }
    public ClientDetailsEntity toEntity(long userId) {
        return new ClientDetailsEntity(userId, firstName,
                lastName);
    }
}
