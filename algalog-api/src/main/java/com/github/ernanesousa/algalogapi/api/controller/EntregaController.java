package com.github.ernanesousa.algalogapi.api.controller;

import com.github.ernanesousa.algalogapi.api.assembler.EntregaAssembler;
import com.github.ernanesousa.algalogapi.api.model.input.EntregaInputModel;
import com.github.ernanesousa.algalogapi.api.model.output.EntregaModel;
import com.github.ernanesousa.algalogapi.domain.model.Entrega;
import com.github.ernanesousa.algalogapi.domain.repository.EntregaRepository;
import com.github.ernanesousa.algalogapi.domain.service.FinalizacaoEntregaService;
import com.github.ernanesousa.algalogapi.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaRepository entregaRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private FinalizacaoEntregaService finalizacaoEntregaService;
    private EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaInputModel entregaInputModel) {
        Entrega novaEntrega = entregaAssembler.toEntity(entregaInputModel);
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);

        return entregaAssembler.toModel(entregaSolicitada);
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId) {
        finalizacaoEntregaService.finalizar(entregaId);
    }

    @GetMapping
    public List<EntregaModel> listar() {
        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
}
