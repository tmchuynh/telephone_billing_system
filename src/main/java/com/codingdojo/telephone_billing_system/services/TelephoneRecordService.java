package com.codingdojo.telephone_billing_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.telephone_billing_system.models.TelephoneRecord;
import com.codingdojo.telephone_billing_system.repositories.TelephoneRecordRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TelephoneRecordService {

	@Autowired
    private TelephoneRecordRepository telephoneRecordRepository;

    public void saveTelephoneRecord(TelephoneRecord telephoneRecord) {
        telephoneRecordRepository.save(telephoneRecord);
    }

    public TelephoneRecord getTelephoneRecordById(Long id) {
        return telephoneRecordRepository.findById(id).orElse(null);
    }
}
