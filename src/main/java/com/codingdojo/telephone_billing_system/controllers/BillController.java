package com.codingdojo.telephone_billing_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.telephone_billing_system.models.Bill;
import com.codingdojo.telephone_billing_system.models.Consumer;
import com.codingdojo.telephone_billing_system.services.BillService;
import com.codingdojo.telephone_billing_system.services.ConsumerService;

@Controller
@RequestMapping("/bills")
public class BillController {
	@Autowired
	private BillService billService;

	@Autowired
	private ConsumerService consumerService;

	@PostMapping
	public void createBill(@RequestBody Bill bill) {
		billService.saveBill(bill);
	}

	@GetMapping("/{id}")
	public String getBillsByConsumerId(@PathVariable Long id, Model model) {
		List<Bill> bills = consumerService.getBillsByConsumerId(id);
		model.addAttribute("bills", bills);

		Consumer consumer = consumerService.getConsumerById(id);
		model.addAttribute("consumerId", id);
		model.addAttribute("firstName", consumer.getFirstName());
		model.addAttribute("lastName", consumer.getLastName());

		// New bill add logic
		model.addAttribute("billsFormAction", "/bills/add");

		Bill bill = new Bill();
		model.addAttribute("bill", bill);

		return "billList.jsp";
	}

	@PostMapping("/add")
	public String addBill(@ModelAttribute("bill") Bill bill, @RequestParam("consumerId") Long consumerId) {
		// Retrieve the consumer based on the provided ID
		Consumer consumer = consumerService.getConsumerById(consumerId);

		// Associate the consumer with the bill
		bill.setConsumer(consumer);

		// Save the bill
		billService.saveBill(bill);

		return "redirect:/bills/" + consumerId;
	}

	@GetMapping("/edit/{id}")
	public String showEditBillForm(@PathVariable Long id, Model model) {
		// Retrieve the bill from the database
		Bill bill = billService.getBillById(id);

		// Retrieve the consumer based on the provided ID
		Consumer consumer = consumerService.getConsumerById(bill.getConsumer().getId());

		model.addAttribute("consumerId", consumer.getId());
		model.addAttribute("firstName", consumer.getFirstName());
		model.addAttribute("lastName", consumer.getLastName());

		List<Bill> bills = consumerService.getBillsByConsumerId(consumer.getId());
		model.addAttribute("bills", bills);

		model.addAttribute("billsFormAction", "/bills/edit/" + id);

		// Add the bill to the model
		model.addAttribute("bill", bill);

		return "billList.jsp";
	}

	@PostMapping("/edit/{id}")
	public String editBill(@PathVariable Long id, Model model, @RequestParam("consumerId") Long consumerId,
			@ModelAttribute("bill") Bill editedBill) {
		// Retrieve the existing bill from the database
		Bill existingBill = billService.getBillById(id);

		List<Bill> bills = consumerService.getBillsByConsumerId(id);
		model.addAttribute("bills", bills);

		// Update the properties of the existing bill with the values from the edited
		// bill
		existingBill.setBillDate(editedBill.getBillDate());
		existingBill.setAmount(editedBill.getAmount());

		// Save the updated bill
		billService.saveBill(existingBill);

		return "redirect:/bills/" + consumerId;
	}

}
