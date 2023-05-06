package com.codingdojo.telephone_billing_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.telephone_billing_system.models.Consumer;
import com.codingdojo.telephone_billing_system.services.ConsumerService;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {
	@Autowired
	private ConsumerService consumerService;

	@PostMapping
	public void createConsumer(@RequestBody Consumer consumer) {
		consumerService.saveConsumer(consumer);
	}

	@GetMapping("/{id}")
	public Consumer getConsumer(@PathVariable Long id) {
		return consumerService.getConsumerById(id);
	}
}
