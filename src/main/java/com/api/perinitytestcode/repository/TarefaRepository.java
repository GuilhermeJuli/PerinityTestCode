package com.api.perinitytestcode.repository;

import com.api.perinitytestcode.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}