package com.jean.api_transacao.dto;

import java.time.OffsetDateTime;

public record TransacaoDTO(Double valor, OffsetDateTime dataHora) {
}
