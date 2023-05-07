package com.codingdojo.telephone_billing_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.telephone_billing_system.services.TelephoneRecordService;

@Controller
@RequestMapping("/telephoneRecords")
public class TelephoneRecordController {
	@Autowired
	private TelephoneRecordService telephoneRecordService;
}
