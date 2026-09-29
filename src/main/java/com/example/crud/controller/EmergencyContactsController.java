package com.example.crud.controller;

import com.example.crud.entity.EmergencyContacts;
import com.example.crud.serivce.EmergencyContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergencyContact")
@CrossOrigin("*")
public class EmergencyContactsController {
    @Autowired
    private EmergencyContactService emergencyContactService;

    @PostMapping("/addContact")
    public void addConctat(@RequestBody EmergencyContacts emergencyContacts){
        emergencyContactService.addContact(emergencyContacts);
    }

    @GetMapping("/getAll")
    public List<EmergencyContacts> getAllContact(){
        return emergencyContactService.getAll();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<EmergencyContacts> DeleteContact(@PathVariable String id){
        emergencyContactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }

}
