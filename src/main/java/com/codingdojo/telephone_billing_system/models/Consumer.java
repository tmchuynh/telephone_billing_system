package com.codingdojo.telephone_billing_system.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="comsumers")
public class Consumer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int numberOfTelephones;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private boolean isPhoneCallUnlimited;
	private Double phoneCallCost;

	private boolean isTextMessageUnlimited;
	private Double textMessageCost;
	
	@OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bill> bills;
	
	public Consumer() {
        // Default constructor
    }

    public Consumer(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public int getNumberOfTelephones() {
		return numberOfTelephones;
	}

	public void setNumberOfTelephones(int numberOfTelephones) {
		this.numberOfTelephones = numberOfTelephones;
	}

	public boolean isPhoneCallUnlimited() {
		return isPhoneCallUnlimited;
	}

	public void setPhoneCallUnlimited(boolean isPhoneCallUnlimited) {
		this.isPhoneCallUnlimited = isPhoneCallUnlimited;
	}

	public Double getPhoneCallCost() {
		return phoneCallCost;
	}

	public void setPhoneCallCost(Double phoneCallCost) {
		this.phoneCallCost = phoneCallCost;
	}

	public boolean isTextMessageUnlimited() {
		return isTextMessageUnlimited;
	}

	public void setTextMessageUnlimited(boolean isTextMessageUnlimited) {
		this.isTextMessageUnlimited = isTextMessageUnlimited;
	}

	public Double getTextMessageCost() {
		return textMessageCost;
	}

	public void setTextMessageCost(Double textMessageCost) {
		this.textMessageCost = textMessageCost;
	}

	
    

}
