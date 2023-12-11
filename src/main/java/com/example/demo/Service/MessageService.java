package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Mensaje;
import com.example.demo.Repositories.MessageRepository;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Mensaje enviarMensaje(Mensaje mensaje) {
        return messageRepository.save(mensaje);
    }

    public List<Mensaje> obtenerMensajesPorReceptor(String receptor) {
        return messageRepository.findByReceptor(receptor);
    }
}