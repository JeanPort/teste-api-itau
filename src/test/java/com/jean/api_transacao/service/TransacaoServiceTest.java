package com.jean.api_transacao.service;

import com.jean.api_transacao.dto.TransacaoDTO;
import com.jean.api_transacao.exception.DataInvalidaException;
import com.jean.api_transacao.exception.JsonIncorretoExcption;
import com.jean.api_transacao.exception.ValorIncorretoException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;

@ExtendWith(MockitoExtension.class)
public class TransacaoServiceTest {

    @InjectMocks
    private TransacaoServiceImpl service;


    @Test
    void deveriaRetornarUmaExceptionQuandoArgumentosNulos() {

        var trasacao = new TransacaoDTO(null, null);
        Assertions.assertThatException().isThrownBy(() -> service.create(trasacao)).isInstanceOf(JsonIncorretoExcption.class);
    }

    @Test
    void deveriaRetornarUmaExceptionDataInvalida() {

        var trasacao = new TransacaoDTO(200.0, OffsetDateTime.parse("2025-02-04T22:43:00.789-03:00"));
        Assertions.assertThatException().isThrownBy(() -> service.create(trasacao)).isInstanceOf(DataInvalidaException.class);
    }

    @Test
    void deveriaRetornarUmaExceptionValorInvalida() {

        var trasacao = new TransacaoDTO(-200.0, OffsetDateTime.now());
        Assertions.assertThatException().isThrownBy(() -> service.create(trasacao)).isInstanceOf(ValorIncorretoException.class);
    }

    @Test
    void deveriaRetornarOkQuandoTransacaoCorreta() {

        var trasacao = new TransacaoDTO(200.0, OffsetDateTime.now());
        service.create(trasacao);
        Assertions.assertThat(this.service.getTransacoes()).contains(trasacao);
    }
}
