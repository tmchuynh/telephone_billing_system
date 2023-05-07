package com.codingdojo.telephone_billing_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingdojo.telephone_billing_system.models.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    Consumer findById(long id);
    List<Consumer> findByLastName(String lastName);
    List<Consumer> findAll();
}
