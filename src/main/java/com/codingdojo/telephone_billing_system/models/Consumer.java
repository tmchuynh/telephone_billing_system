package com.codingdojo.telephone_billing_system.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comsumers")
public class Consumer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone_number")
    private String phoneNumber;
	
	@OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TelephoneRecord> telephoneRecords;
	
	@OneToOne(mappedBy = "consumer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Bill bill;
	
	public Consumer() {
        // Default constructor
    }

    public Consumer(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<TelephoneRecord> getTelephoneRecords() {
        return telephoneRecords;
    }

    public void setTelephoneRecords(List<TelephoneRecord> telephoneRecords) {
        this.telephoneRecords = telephoneRecords;
    }

    public void addTelephoneRecord(TelephoneRecord telephoneRecord) {
        telephoneRecord.setConsumer(this);
        telephoneRecords.add(telephoneRecord);
    }

    public void removeTelephoneRecord(TelephoneRecord telephoneRecord) {
        telephoneRecords.remove(telephoneRecord);
    }
    
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

}
