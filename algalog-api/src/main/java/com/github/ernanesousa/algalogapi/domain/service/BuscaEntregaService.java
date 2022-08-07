package com.github.ernanesousa.algalogapi.domain.service;

import com.github.ernanesousa.algalogapi.domain.exception.EntidadeNaoEncontradaException;
import com.github.ernanesousa.algalogapi.domain.model.Entrega;
import com.github.ernanesousa.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));

    }
}
