package com.codingdojo.telephone_billing_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.telephone_billing_system.models.Phone;
import com.codingdojo.telephone_billing_system.services.PhoneService;

@Controller
@RequestMapping("/phones")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping
    public List<Phone> getAllPhones() {
        return phoneService.getAllPhones();
    }

    @GetMapping("/{id}")
    public Phone getPhoneById(@PathVariable Long id) {
        return phoneService.getPhoneById(id);
    }

    @PostMapping
    public void createPhone(@RequestBody Phone phone) {
        phoneService.savePhone(phone);
    }

    @PutMapping("/{id}")
    public void updatePhone(@PathVariable Long id, @RequestBody Phone updatedPhone) {
        Phone phone = phoneService.getPhoneById(id);
        if (phone != null) {
            phone.setPhoneNumber(updatedPhone.getPhoneNumber());
            phoneService.savePhone(phone);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePhone(@PathVariable Long id) {
        phoneService.deletePhoneById(id);
    }
}