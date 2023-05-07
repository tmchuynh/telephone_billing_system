package com.codingdojo.telephone_billing_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.telephone_billing_system.models.Consumer;
import com.codingdojo.telephone_billing_system.services.ConsumerService;

@Controller
public class HomeController {
	@Autowired
    private ConsumerService consumerService;
	
	@GetMapping("/")
	public String index(Model model) {
	    List<Consumer> consumers = consumerService.getAllConsumers();
	    model.addAttribute("consumers", consumers);
	    return "index.jsp";
	}

	


}
