package com.github.ernanesousa.algalogapi.api.model.input;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteIdInputModel {

    @NotNull
    private Long id;
}
