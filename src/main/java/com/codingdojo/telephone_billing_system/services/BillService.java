package com.codingdojo.telephone_billing_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.telephone_billing_system.models.Bill;
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
}
