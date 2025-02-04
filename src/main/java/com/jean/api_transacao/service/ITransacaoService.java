package com.jean.api_transacao.service;

import com.jean.api_transacao.dto.TransacaoDTO;

public interface ITransacaoService {

    void create(TransacaoDTO dto);
    void limpar();
}
