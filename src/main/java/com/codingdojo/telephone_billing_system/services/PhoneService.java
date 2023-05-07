package com.codingdojo.telephone_billing_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.telephone_billing_system.models.Phone;
import com.codingdojo.telephone_billing_system.repositories.PhoneRepository;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    public Phone getPhoneById(Long id) {
        return phoneRepository.findById(id).orElse(null);
    }

    public void savePhone(Phone phone) {
        phoneRepository.save(phone);
    }

    public void deletePhoneById(Long id) {
        phoneRepository.deleteById(id);
    }
}
