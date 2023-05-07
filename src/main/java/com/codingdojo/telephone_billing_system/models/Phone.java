package com.codingdojo.telephone_billing_system.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @ManyToMany(mappedBy = "phones")
    private List<TelephoneRecord> telephoneRecords;

    // Constructors, getters, and setters

    public Phone() {
        // Default constructor
    }

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}

