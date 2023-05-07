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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="telephoneRecord")
public class TelephoneRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column(name = "call_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date callDate;

    
    @Column(name = "call_duration")
    private int callDuration;
    
    private List<Bill> bills;


    public TelephoneRecord() {
        // Default constructor
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCallDate() {
		return callDate;
	}

	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}

	public int getDuration() {
		return callDuration;
	}

	public void setDuration(int callDuration) {
		this.callDuration = callDuration;
	}

	public int getCallDuration() {
	    return callDuration;
	}

	public void setCallDuration(int callDuration) {
	    this.callDuration = callDuration;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}



}
