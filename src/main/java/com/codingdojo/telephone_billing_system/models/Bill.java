package com.codingdojo.telephone_billing_system.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bill_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date billDate;


    @Column(name = "amount")
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;
    
    @ManyToMany(mappedBy = "bills")
    private List<TelephoneRecord> telephoneRecords;

	public Bill() {
        // Default constructor
    }

    public Bill(Date billDate, double amount) {
        this.billDate = billDate;
        this.amount = amount;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Consumer getConsumer() {
        return consumer;
    }
	
	public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

	public List<TelephoneRecord> getTelephoneRecords() {
		return telephoneRecords;
	}

	public void setTelephoneRecords(List<TelephoneRecord> telephoneRecords) {
		this.telephoneRecords = telephoneRecords;
	}

}
