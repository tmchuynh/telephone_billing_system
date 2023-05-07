package com.codingdojo.telephone_billing_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.telephone_billing_system.models.TextMessage;
import com.codingdojo.telephone_billing_system.repositories.TextMessageRepository;

@Service
public class TextMessageService {
	private  TextMessageRepository textMessageRepository;

    public TextMessageService(TextMessageRepository textMessageRepository) {
        this.textMessageRepository = textMessageRepository;
    }

    public List<TextMessage> getAllTextMessages() {
        return textMessageRepository.findAll();
    }

    public TextMessage getTextMessageById(Long id) {
        return textMessageRepository.findById(id).orElse(null);
    }

    public void saveTextMessage(TextMessage textMessage) {
        textMessageRepository.save(textMessage);
    }

    public void deleteTextMessage(Long id) {
        textMessageRepository.deleteById(id);
    }
}
