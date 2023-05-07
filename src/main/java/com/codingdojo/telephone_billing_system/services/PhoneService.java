package com.codingdojo.telephone_billing_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.telephone_billing_system.models.Phone;
import com.codingdojo.telephone_billing_system.repositories.PhoneRepository;

@Service
public class PhoneService {
    private PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    public Phone getPhoneById(Long id) {
        return phoneRepository.findById(id).orElse(null);
    }

    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public void deletePhoneById(Long id) {
        phoneRepository.deleteById(id);
    }
}
