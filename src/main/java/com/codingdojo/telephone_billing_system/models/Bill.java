package com.codingdojo.telephone_billing_system.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bills")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "consumer_id")
    private Long consumerId;

    @Column(name = "bill_date")
    private Date billDate;

    @Column(name = "amount")
    private double amount;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer")
    private Consumer consumer;

    public Bill() {
        // Default constructor
    }

    public Bill(Long consumerId, Date billDate, double amount) {
        this.consumerId = consumerId;
        this.billDate = billDate;
        this.amount = amount;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
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

}
