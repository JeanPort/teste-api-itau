package com.jean.api_transacao.controller;

import com.jean.api_transacao.dto.TransacaoDTO;
import com.jean.api_transacao.service.ITransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {

    private final ITransacaoService service;

    public TransacaoController(ITransacaoService service) {
        this.service = service;
    }

    @PostMapping("transacao")
    public ResponseEntity<Void> create(@RequestBody TransacaoDTO dto) {
        service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("transacao")
    public ResponseEntity<Void> delete() {
        service.limpar();
        return ResponseEntity.ok().build();
    }
}
