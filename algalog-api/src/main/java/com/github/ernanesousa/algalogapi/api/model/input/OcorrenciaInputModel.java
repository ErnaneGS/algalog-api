package com.github.ernanesousa.algalogapi.api.model.input;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OcorrenciaInputModel {

    @NotBlank
    private String descricao;

}
