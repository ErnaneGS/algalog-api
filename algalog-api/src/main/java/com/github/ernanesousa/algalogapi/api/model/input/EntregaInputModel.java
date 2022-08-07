package com.github.ernanesousa.algalogapi.api.model.input;

import lombok.Getter;
import lombok.Setter;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class EntregaInputModel {

    @Valid
    @NotNull
    private ClienteIdInputModel cliente;

    @Valid
    @NotNull
    private DestinatarioInputModel destinatario;

    @NotNull
    private BigDecimal taxa;
}
