package com.codingdojo.telephone_billing_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.telephone_billing_system.models.TelephoneRecord;
import com.codingdojo.telephone_billing_system.services.TelephoneRecordService;

@RestController
@RequestMapping("/telephone-records")
public class TelephoneRecordController {
	@Autowired
	private TelephoneRecordService telephoneRecordService;

	@PostMapping
	public void createTelephoneRecord(@RequestBody TelephoneRecord telephoneRecord) {
		telephoneRecordService.saveTelephoneRecord(telephoneRecord);
	}

	@GetMapping("/{id}")
	public TelephoneRecord getTelephoneRecord(@PathVariable Long id) {
		return telephoneRecordService.getTelephoneRecordById(id);
	}
}
