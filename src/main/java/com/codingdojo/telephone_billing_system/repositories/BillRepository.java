package com.codingdojo.telephone_billing_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingdojo.telephone_billing_system.models.Bill;
import com.codingdojo.telephone_billing_system.models.Consumer;
import com.codingdojo.telephone_billing_system.models.TelephoneRecord;

public interface BillRepository extends JpaRepository<Bill, Long> {
    // Find bills by consumer
    List<Bill> findByConsumer(Consumer consumer);

    // Find bills by consumer ID
    List<Bill> findByConsumerId(Long consumerId);

    // Find bills by telephone records
    List<Bill> findByTelephoneRecords(TelephoneRecord telephoneRecord);

    // Find bills by telephone record IDs
    List<Bill> findByTelephoneRecordsId(Long telephoneRecordId);
}
