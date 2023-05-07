package com.codingdojo.telephone_billing_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingdojo.telephone_billing_system.models.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
