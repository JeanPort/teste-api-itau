package com.jean.api_transacao.service;

import com.jean.api_transacao.dto.EstatisticaDTO;
import com.jean.api_transacao.dto.TransacaoDTO;
import org.springframework.stereotype.Service;

@Service
public class EstatisticaServiceImpl implements IEstatisticaService{

    private final TransacaoServiceImpl transacaoService;

    public EstatisticaServiceImpl(TransacaoServiceImpl transacaoService) {
        this.transacaoService = transacaoService;
    }


    @Override
    public EstatisticaDTO findEstatisti() {

        var list = transacaoService.findTransacao();
        if (list.isEmpty()) {
            return new EstatisticaDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        var sumary = list.stream().mapToDouble(TransacaoDTO::valor).summaryStatistics();

        return new EstatisticaDTO(sumary.getCount(), sumary.getSum(), sumary.getAverage(), sumary.getMin(), sumary.getMax());
    }
}
