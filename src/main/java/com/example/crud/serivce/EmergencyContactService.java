package com.example.crud.serivce;

import com.example.crud.entity.EmergencyContacts;
import com.example.crud.repository.EmergencyContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmergencyContactService {
    @Autowired
    private EmergencyContactsRepository emergencyContactsRepository;

    //add contact
    public void addContact(EmergencyContacts emergencyContacts) {
        emergencyContactsRepository.save(emergencyContacts);
    }

    //get all contact
    public List<EmergencyContacts> getAll(){
       return emergencyContactsRepository.findAll(Sort.by(Sort.Direction.ASC, "serviceName"));
    }

    //find contact by id
    public EmergencyContacts findById(String id){
        return  emergencyContactsRepository.findById(id).orElseThrow(()-> new RuntimeException("Contact not found"));
    }

    //update contact
    public EmergencyContacts updateContact(String id, EmergencyContacts contacts){
        EmergencyContacts existing = emergencyContactsRepository.findById(id).orElseThrow(()->new RuntimeException(("contact not found")));
        existing.setServiceName(contacts.getServiceName());
        existing.setPhoneNumber(contacts.getPhoneNumber());
        existing.setCategory(contacts.getCategory());
        existing.setAlternatePhoneNumber(contacts.getAlternatePhoneNumber());
        existing.setAddress(contacts.getAddress());
        existing.setCity(contacts.getCity());
        existing.setState(contacts.getState());
        existing.setEmail(contacts.getEmail());
        existing.setPinCode(contacts.getPinCode());
        existing.setAvailable24x7(contacts.isAvailable24x7());
        existing.setDescription(contacts.getDescription());

        return  emergencyContactsRepository.save(existing);


    }
    //delete contact
    public void deleteContact(String id){
        emergencyContactsRepository.deleteById(id);
    }
}
