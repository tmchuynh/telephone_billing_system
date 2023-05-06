package com.codingdojo.telephone_billing_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.telephone_billing_system.models.Consumer;
import com.codingdojo.telephone_billing_system.repositories.ConsumerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConsumerService {
	 @Autowired
	    private ConsumerRepository consumerRepository;

	    public void saveConsumer(Consumer consumer) {
	        consumerRepository.save(consumer);
	    }

	    public Consumer getConsumerById(Long id) {
	        return consumerRepository.findById(id).orElse(null);
	    }
	
}
