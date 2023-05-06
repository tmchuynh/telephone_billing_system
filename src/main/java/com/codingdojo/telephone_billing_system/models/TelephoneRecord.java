package com.codingdojo.telephone_billing_system.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="telephoneRecord")
public class TelephoneRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "consumer_id")
    private Long consumerId;
    
    @Column(name = "call_date")
    private Date callDate;
    
    @Column(name = "duration")
    private int duration;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer")
    private Consumer consumer;

    public TelephoneRecord() {
        // Default constructor
    }

    public TelephoneRecord(Long consumerId, Date callDate, int duration) {
        this.consumerId = consumerId;
        this.callDate = callDate;
        this.duration = duration;
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

	public Date getCallDate() {
		return callDate;
	}

	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
}
