package com.github.ernanesousa.algalogapi.domain.service;

import com.github.ernanesousa.algalogapi.domain.model.Cliente;
import com.github.ernanesousa.algalogapi.domain.model.Entrega;
import com.github.ernanesousa.algalogapi.domain.model.StatusEntrega;
import com.github.ernanesousa.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private ClienteService clienteService;
    private EntregaRepository entregaRepository;
    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = clienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }

}
