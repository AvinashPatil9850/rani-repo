package com.example.crud.repository;

import com.example.crud.entity.EmergencyContacts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyContactsRepository extends MongoRepository<EmergencyContacts, String> {
}
