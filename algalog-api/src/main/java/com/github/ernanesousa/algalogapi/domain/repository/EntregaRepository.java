package com.github.ernanesousa.algalogapi.domain.repository;

import com.github.ernanesousa.algalogapi.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    
}


