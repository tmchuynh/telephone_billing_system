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
@Table(name = "textMessages")
public class TextMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message_content")
    private String messageContent;

    @ManyToMany(mappedBy = "textMessages")
    private List<TelephoneRecord> telephoneRecords;

    public TextMessage() {
        // Default constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public List<TelephoneRecord> getTelephoneRecords() {
        return telephoneRecords;
    }

    public void setTelephoneRecords(List<TelephoneRecord> telephoneRecords) {
        this.telephoneRecords = telephoneRecords;
    }
}

