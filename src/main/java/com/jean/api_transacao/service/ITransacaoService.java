package com.jean.api_transacao.service;

import com.jean.api_transacao.dto.TransacaoDTO;

import java.util.List;

public interface ITransacaoService {

    void create(TransacaoDTO dto);
    void limpar();

    List<TransacaoDTO> findTransacao();
}
