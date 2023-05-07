package com.codingdojo.telephone_billing_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingdojo.telephone_billing_system.models.Bill;
import com.codingdojo.telephone_billing_system.models.Consumer;
import com.codingdojo.telephone_billing_system.models.TelephoneRecord;

public interface TelephoneRecordRepository extends JpaRepository<TelephoneRecord, Long> {
    // Find telephone records by consumer
    List<TelephoneRecord> findByConsumer(Consumer consumer);

    // Find telephone records by consumer ID
    List<TelephoneRecord> findByConsumerId(Long consumerId);

    // Find telephone records by call duration less than a given duration
    List<TelephoneRecord> findByCallDurationLessThan(int duration);

    // Find telephone records by bills
    List<TelephoneRecord> findByBills(Bill bill);

    // Find telephone records by bill IDs
    List<TelephoneRecord> findByBillsId(Long billId);
}

