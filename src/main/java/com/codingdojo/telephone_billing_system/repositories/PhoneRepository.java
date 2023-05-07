package com.codingdojo.telephone_billing_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.telephone_billing_system.models.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
