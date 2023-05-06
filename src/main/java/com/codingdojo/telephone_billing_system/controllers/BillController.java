package com.codingdojo.telephone_billing_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.telephone_billing_system.models.Bill;
import com.codingdojo.telephone_billing_system.services.BillService;

@RestController
@RequestMapping("/bills")
public class BillController {
	@Autowired
	private BillService billService;

	@PostMapping
	public void createBill(@RequestBody Bill bill) {
		billService.saveBill(bill);
	}

	@GetMapping("/{id}")
	public Bill getBill(@PathVariable Long id) {
		return billService.getBillById(id);
	}
}
