package com.codingdojo.telephone_billing_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.telephone_billing_system.models.Bill;
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

	public List<Consumer> getAllConsumers() {
	    return consumerRepository.findAll();
	}

	public List<Bill> getBillsByConsumerId(Long id) {
	    Consumer consumer = consumerRepository.findById(id).orElse(null);
	    if (consumer == null) {
	        throw new IllegalArgumentException("Consumer not found with ID: " + id);
	    }
	    return consumer.getBills();
	}

	public void addBillToConsumer(Long consumerId, Bill bill) {
	    Consumer consumer = getConsumerById(consumerId);
	    if (consumer != null) {
	        consumer.getBills().add(bill);
	        bill.setConsumer(consumer);
	        consumerRepository.save(consumer);
	    }
	}

	public void removeBillFromConsumer(Long consumerId, Bill bill) {
	    Consumer consumer = getConsumerById(consumerId);
	    if (consumer != null) {
	        consumer.getBills().remove(bill);
	        bill.setConsumer(null);
	        consumerRepository.save(consumer);
	    }
	}


}
