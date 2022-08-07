package com.github.ernanesousa.algalogapi.api.controller;

import com.github.ernanesousa.algalogapi.api.assembler.OcorrenciaAssembler;
import com.github.ernanesousa.algalogapi.api.model.input.OcorrenciaInputModel;
import com.github.ernanesousa.algalogapi.api.model.output.OcorrenciaModel;
import com.github.ernanesousa.algalogapi.domain.model.Entrega;
import com.github.ernanesousa.algalogapi.domain.model.Ocorrencia;
import com.github.ernanesousa.algalogapi.domain.service.BuscaEntregaService;
import com.github.ernanesousa.algalogapi.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcoorenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId,
                                     @Valid @RequestBody OcorrenciaInputModel ocorrenciaInputModel) {

        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
                .registrar(entregaId, ocorrenciaInputModel.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);

    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }




}
