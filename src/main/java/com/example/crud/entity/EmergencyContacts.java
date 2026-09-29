package com.example.crud.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Emergency-contacts")
public class EmergencyContacts {
    @Id
    private String id;

    private String serviceName;

    private String category;

    private String phoneNumber;

    private String alternatePhoneNumber;

    private String address;

    private String city;

    private String state;

    private String pinCode;

    private String email;

    private boolean available24x7;

    private String description;
}
