package com.jean.api_transacao.service;

import com.jean.api_transacao.dto.TransacaoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoServiceImpl implements ITransacaoService{

    private List<TransacaoDTO> transacoes = new ArrayList<>();


    @Override
    public void create(TransacaoDTO dto) {

    }

    @Override
    public void limpar() {

    }
}
