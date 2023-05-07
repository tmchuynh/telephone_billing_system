package com.codingdojo.telephone_billing_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.telephone_billing_system.models.Bill;
import com.codingdojo.telephone_billing_system.models.TelephoneRecord;
import com.codingdojo.telephone_billing_system.repositories.BillRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BillService {
	@Autowired
	private BillRepository billRepository;

	public void saveBill(Bill bill) {
		billRepository.save(bill);
	}

	public Bill getBillById(Long id) {
		return billRepository.findById(id).orElse(null);
	}

	public List<Bill> getBillsByConsumerId(Long id) {
		return billRepository.findByConsumerId(id);
	}

	public void addTelephoneRecordToBill(Long billId, TelephoneRecord telephoneRecord) {
		Bill bill = getBillById(billId);
		if (bill != null) {
			bill.getTelephoneRecords().add(telephoneRecord);
			telephoneRecord.getBills().add(bill);
			billRepository.save(bill);
		}
	}

	public void removeTelephoneRecordFromBill(Long billId, TelephoneRecord telephoneRecord) {
		Bill bill = getBillById(billId);
		if (bill != null) {
			bill.getTelephoneRecords().remove(telephoneRecord);
			telephoneRecord.getBills().remove(bill);
			billRepository.save(bill);
		}
	}
}