package com.jean.api_transacao.service;

import com.jean.api_transacao.dto.TransacaoDTO;
import com.jean.api_transacao.exception.DataInvalidaException;
import com.jean.api_transacao.exception.JsonIncorretoExcption;
import com.jean.api_transacao.exception.ValorIncorretoException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoServiceImpl implements ITransacaoService{

    private List<TransacaoDTO> transacoes = new ArrayList<>();


    @Override
    public void create(TransacaoDTO dto) {

        validateJson(dto);
        validateDate(dto);
        validateValor(dto);

        this.transacoes.add(dto);
    }



    @Override
    public void limpar() {
        this.transacoes.clear();
    }

    @Override
    public List<TransacaoDTO> findTransacao() {

        var timeBefore = OffsetDateTime.now().minusMinutes(10);
        return this.transacoes.stream().filter(dto -> dto.dataHora().isAfter(timeBefore)).toList();
    }

    private void validateValor(TransacaoDTO dto) {
        if (dto.valor() < 0) {
            throw new ValorIncorretoException("Valor deve ser maior que zero");
        }
    }

    private void validateDate(TransacaoDTO dto) {
        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            throw new DataInvalidaException("Data incorreta");
        }
    }

    private void validateJson(TransacaoDTO dto) {
        if (dto.dataHora() == null || dto.valor() == null) {
            throw new JsonIncorretoExcption("Data ou valor não pode ser null");
        }
    }
}
