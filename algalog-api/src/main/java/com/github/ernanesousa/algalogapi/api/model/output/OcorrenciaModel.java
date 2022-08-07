package com.github.ernanesousa.algalogapi.api.model.output;

import lombok.Getter;
import lombok.Setter;
import java.time.OffsetDateTime;

@Getter
@Setter
public class OcorrenciaModel {

    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;

}
