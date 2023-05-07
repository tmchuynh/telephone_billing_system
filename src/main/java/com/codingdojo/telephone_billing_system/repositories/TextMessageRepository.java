package com.codingdojo.telephone_billing_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingdojo.telephone_billing_system.models.TextMessage;

public interface TextMessageRepository extends JpaRepository<TextMessage, Long> {

	List<TextMessage> findAll();

}
