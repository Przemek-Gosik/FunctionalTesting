package com.example.functionaltesting.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Client {
    ClientDetails clientDetails;
    ClientContact clientContacts;
}
