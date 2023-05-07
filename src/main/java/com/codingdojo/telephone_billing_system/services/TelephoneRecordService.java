package com.codingdojo.telephone_billing_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.telephone_billing_system.models.Bill;
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
	
    public List<TelephoneRecord> getTelephoneRecordsByBillId(Long id) {
        return telephoneRecordRepository.findByBillsId(id);
    }

	public void addBillToTelephoneRecord(Long telephoneRecordId, Bill bill) {
	    TelephoneRecord telephoneRecord = getTelephoneRecordById(telephoneRecordId);
	    if (telephoneRecord != null) {
	        telephoneRecord.getBills().add(bill);
	        bill.getTelephoneRecords().add(telephoneRecord);
	        telephoneRecordRepository.save(telephoneRecord);
	    }
	}

	public void removeBillFromTelephoneRecord(Long telephoneRecordId, Bill bill) {
	    TelephoneRecord telephoneRecord = getTelephoneRecordById(telephoneRecordId);
	    if (telephoneRecord != null) {
	        telephoneRecord.getBills().remove(bill);
	        bill.getTelephoneRecords().remove(telephoneRecord);
	        telephoneRecordRepository.save(telephoneRecord);
	    }
	}


}
