package com.codingdojo.telephone_billing_system.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.telephone_billing_system.models.Consumer;
import com.codingdojo.telephone_billing_system.services.ConsumerService;

@Controller
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
	
	@GetMapping("/add")
    public String showAddCustomerForm() {
        return "addCustomer.jsp";
    }
	
	
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("firstName") String firstName,
	                           @RequestParam("lastName") String lastName) {
	    Consumer newConsumer = new Consumer();
	    newConsumer.setFirstName(firstName);
	    newConsumer.setLastName(lastName);

	    // Assign random values to numberOfTelephones
	    int numberOfTelephones = generateRandomNumberOfTelephones();
	    newConsumer.setNumberOfTelephones(numberOfTelephones);

	    // Assign random values to isPhoneCallUnlimited and isTextMessageUnlimited
	    boolean isPhoneCallUnlimited = getRandomBoolean();
	    boolean isTextMessageUnlimited = getRandomBoolean();
	    newConsumer.setPhoneCallUnlimited(isPhoneCallUnlimited);
	    newConsumer.setTextMessageUnlimited(isTextMessageUnlimited);

	    // Assign random value to textMessageCost if isTextMessageUnlimited is false
	    if (!isTextMessageUnlimited) {
	        double textMessageCost = getRandomTextMessageCost();
	        newConsumer.setTextMessageCost(textMessageCost);
	    } else {
	        newConsumer.setTextMessageCost(null);
	    }
	    
	    if (!isPhoneCallUnlimited) {
	        double phoneCallCost = getRandomTextMessageCost();
	        newConsumer.setPhoneCallCost(phoneCallCost);
	    } else {
	        newConsumer.setPhoneCallCost(null);
	    }

	    consumerService.saveConsumer(newConsumer);

	    return "redirect:/";
	}
	
	private int generateRandomNumberOfTelephones() {
	    // Add your logic here to generate a random number
	    // Example: Generating a random number between 1 and 10
	    int minNumberOfTelephones = 1;
	    int maxNumberOfTelephones = 10;
	    Random random = new Random();
	    return random.nextInt(maxNumberOfTelephones - minNumberOfTelephones + 1) + minNumberOfTelephones;
	}
	
	private double getRandomTextMessageCost() {
	    // Generate a random text message cost, e.g., between 0.01 and 0.10
	    return new Random().nextDouble() * (2.75 - 0.75) + 0.75;
	}
	
	private boolean getRandomBoolean() {
	    // Generate a random boolean value
	    return new Random().nextBoolean();
	}
}
