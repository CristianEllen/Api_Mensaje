package com.example.demo.Controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Mensaje;

import com.example.demo.Service.MessageService;


@RestController
@RequestMapping("/mensajes")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/enviar")
    public ResponseEntity<Mensaje> enviarMensaje(@RequestBody Mensaje mensaje) {
        Mensaje mensajeEnviado = messageService.enviarMensaje(mensaje);
        return new ResponseEntity<>(mensajeEnviado, HttpStatus.CREATED);
    }

    @GetMapping("/receptor/{receptor}")
    public ResponseEntity<List<Mensaje>> obtenerMensajesPorReceptor(@PathVariable String receptor) {
        List<Mensaje> mensajes = messageService.obtenerMensajesPorReceptor(receptor);
        return new ResponseEntity<>(mensajes, HttpStatus.OK);
    }
}