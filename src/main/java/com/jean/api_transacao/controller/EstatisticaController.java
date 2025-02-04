package com.jean.api_transacao.controller;

import com.jean.api_transacao.dto.EstatisticaDTO;
import com.jean.api_transacao.service.IEstatisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstatisticaController {

    private final IEstatisticaService service;

    public EstatisticaController(IEstatisticaService service) {
        this.service = service;
    }

    @GetMapping("estatistica")
    public ResponseEntity<EstatisticaDTO> findEstatistica() {
        var res = service.findEstatisti();
        return ResponseEntity.ok(res);
    }
}
